package org.example.labb3.dto;

import java.util.List;

public record WeatherComparisonResult(
        WeatherForecast bestForecast,
        List<WeatherForecast> allForecasts
) {}

