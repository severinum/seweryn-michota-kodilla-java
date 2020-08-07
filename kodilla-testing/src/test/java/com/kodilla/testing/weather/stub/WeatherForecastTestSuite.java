package com.kodilla.testing.weather.stub;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WeatherForecastTestSuite {

    @Test
    public void testCalculateForecastWithStub() {
        // given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        // when
        int qtyOfSensors = weatherForecast.calculateForecast().size();
        // then
        Assertions.assertEquals(6, qtyOfSensors);
    }
}
