package com.kodilla.testing.weather.stub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast(){
        Map<String, Double> resultMap  = new HashMap<>();

        for(Map.Entry<String, Double> temperature:  temperatures.getTempreatures().entrySet()){
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }


    public double calculateAverageTemperature(){
        double tempSum = 0;
        for(Map.Entry<String, Double> temperature: temperatures.getTempreatures().entrySet()){
            tempSum += temperature.getValue();
        }
        return tempSum / temperatures.getTempreatures().size();
    }

    public double calculateTemperaturesMedian(){
        if(temperatures.getTempreatures().size() == 0){
            return 0;
        }
        double median = 0.0;
        Double temperaturesArray[] = new Double[temperatures.getTempreatures().size()];

        int idx = 0;
        for(Map.Entry<String, Double> temperatures: temperatures.getTempreatures().entrySet()){
            temperaturesArray[idx] = temperatures.getValue();
            idx++;
        }

        Arrays.sort(temperaturesArray);

        if(temperaturesArray.length % 2 == 0){
            median = ((double)temperaturesArray[(temperaturesArray.length / 2) - 1] + (double) temperaturesArray[(temperaturesArray.length / 2)]) / 2;
        } else {
            median = temperaturesArray[temperaturesArray.length / 2];
        }

        return median;
    }

}
