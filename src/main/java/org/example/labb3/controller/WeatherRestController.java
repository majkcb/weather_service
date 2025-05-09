package org.example.labb3.controller;

import lombok.AllArgsConstructor;
import org.example.labb3.dto.WeatherForecast;
import org.example.labb3.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/weather")
public class WeatherRestController {

    private final WeatherService weatherService;

    @GetMapping("/forecast")
    public WeatherForecast getForecast() {
        return weatherService.getOptimizedForecast();
    }
}
