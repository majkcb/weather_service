package org.example.labb3.service;

import lombok.RequiredArgsConstructor;
import org.example.labb3.client.met.METClient;
import org.example.labb3.client.owm.OWMClient;
import org.example.labb3.client.smhi.SMHIClient;
import org.example.labb3.dto.WeatherForecast;
import org.example.labb3.model.met.METResponse;
import org.example.labb3.model.met.MetTimeseries;
import org.example.labb3.model.owm.OWMForecastEntry;
import org.example.labb3.model.owm.OWMResponse;
import org.example.labb3.model.smhi.SMHIResponse;
import org.example.labb3.model.smhi.TimeSeries;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private static final DateTimeFormatter ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    private static final DateTimeFormatter OWM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final SMHIClient smhiClient;
    private final METClient metClient;
    private final OWMClient owmClient;

    public WeatherForecast getOptimizedForecast() {
        WeatherForecast smhi = getSMHIForecast();
        WeatherForecast met = getMETForecast();
        WeatherForecast owm = getOWMForecast();

        return Stream.of(smhi, met, owm)
                .max(Comparator.comparingDouble(WeatherForecast::temp))
                .orElseThrow(() -> new RuntimeException("No forecasts available"));
    }

    private WeatherForecast getSMHIForecast() {
        SMHIResponse response = smhiClient.getForecast();
        TimeSeries forecast = findClosestForecast(response.getTimeSeries(), TimeSeries::getValidTime, ISO_DATE_TIME_FORMATTER);

        Double temperature = findParameterValue(forecast, "t");
        Double humidity = findParameterValue(forecast, "r");
        LocalDateTime timestamp = LocalDateTime.parse(forecast.getValidTime(), ISO_DATE_TIME_FORMATTER);

        return new WeatherForecast("SMHI", temperature, humidity, timestamp);
    }

    private WeatherForecast getMETForecast() {
        METResponse response = metClient.getForecast();
        MetTimeseries forecast = findClosestForecast(response.getProperties().getTimeseries(), MetTimeseries::getTime, ISO_DATE_TIME_FORMATTER);

        Double temperature = forecast.getData().getInstant().getDetails().getAirTemperature();
        Double humidity = forecast.getData().getInstant().getDetails().getRelativeHumidity();
        LocalDateTime timestamp = LocalDateTime.parse(forecast.getTime(), ISO_DATE_TIME_FORMATTER);

        return new WeatherForecast("MET", temperature, humidity, timestamp);
    }

    private WeatherForecast getOWMForecast() {
        OWMResponse response = owmClient.getForecast();
        OWMForecastEntry forecast = findClosestForecast(response.getList(), OWMForecastEntry::getDateTime, OWM_FORMATTER);

        double temperature = forecast.getMain().getTemp();
        double humidity = forecast.getMain().getHumidity();
        LocalDateTime timestamp = LocalDateTime.parse(forecast.getDateTime(), OWM_FORMATTER);

        return new WeatherForecast("OWM", temperature, humidity, timestamp);
    }

    // Generisk hjälpfunktion för att slippa upprepa samma kod i varje forecast
    private <T> T findClosestForecast(List<T> list, Function<T, String> timeExtractor, DateTimeFormatter formatter) {
        LocalDateTime targetTime = getTargetTime();

        return list.stream()
                .min(Comparator.comparing(item -> {
                    LocalDateTime itemTime = LocalDateTime.parse(timeExtractor.apply(item), formatter);
                    return Duration.between(itemTime, targetTime).abs();
                }))
                .orElseThrow(() -> new RuntimeException("No matching forecast found"));
    }

    private LocalDateTime getTargetTime() {
        return LocalDateTime.now().plusHours(24);
    }

    private Double findParameterValue(TimeSeries timeSeries, String paramName) {
        return timeSeries.getParameters().stream()
                .filter(p -> p.getName().equalsIgnoreCase(paramName))
                .findFirst()
                .map(p -> p.getValues().get(0))
                .orElseThrow(() -> new RuntimeException("Parameter not found: " + paramName));
    }
}
