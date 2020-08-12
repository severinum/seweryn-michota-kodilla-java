package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    public void init(){
        System.out.println("Staring new test ...");
    }

    @Test
    void testCalculateForecastWithMock(){
        // given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTempreatures()).thenReturn(temperaturesMap);
        // when
        int qtyOfSensors  = weatherForecast.calculateForecast().size();
        // then
        Assertions.assertEquals(5, qtyOfSensors);
    }

    @Test
    public void shouldCalculateCorrectAvgTemperature(){
        // given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTempreatures()).thenReturn(temperaturesMap);
        // when
        double avgTemperature = weatherForecast.calculateAverageTemperature();
        // then
        Assertions.assertEquals(25.56, avgTemperature, 0.01 );
    }

    @Test
    public void shouldCalculateCorrectTemperaturesMedian(){
        // given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Gdansk", 26.1);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Bydgoszcz", 26.7);
        when(temperaturesMock.getTempreatures()).thenReturn(temperaturesMap);
        // when
        double temperaturesMedian = weatherForecast.calculateTemperaturesMedian();
        // then
        Assertions.assertEquals(25.8,temperaturesMedian );
    }
}