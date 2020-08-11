package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherForecastTestSuite {

    @Test
    public void testCalculateForecastWithStub() {
        // given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        // when
        int qtyOfSensors = weatherForecast.calculateForecast().size();
        // then
        Assertions.assertEquals(5, qtyOfSensors);
    }
}
