package org.example.labb3.dto;

import java.time.LocalDateTime;

public record WeatherForecast(String origin, double temp, double humidity, LocalDateTime timestamp) {
}
