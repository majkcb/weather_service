package org.example.labb3.controller;

import lombok.AllArgsConstructor;
import org.example.labb3.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class WeatherViewController {

    private final WeatherService weatherService;

    @GetMapping("/forecast")
    public String showForecast(Model model) {
        var comparisonResult = weatherService.getForecastComparison();
        model.addAttribute("forecast", comparisonResult.bestForecast());
        model.addAttribute("allForecasts", comparisonResult.allForecasts());
        return "forecast";
    }

}
