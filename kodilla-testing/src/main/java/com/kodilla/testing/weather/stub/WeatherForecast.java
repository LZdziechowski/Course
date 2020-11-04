package com.kodilla.testing.weather.stub;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {

    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {

        final Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {

            //adding 1 Celsius degree to current value as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }

    public double averageTemperature() {

        final double result;
        double sum = 0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        result = sum / temperatures.getTemperatures().size();

        return result;
        //BigDecimal resultBigDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_EVEN);
        //return resultBigDecimal.doubleValue();
    }

    public double medianTemperature() {

        final double result;
        Double[] tab = new Double[temperatures.getTemperatures().size()];
        int i = 0;

        for (Double temperature : temperatures.getTemperatures().values()) {
            tab[i] = temperature;
            i++;
        }
        Arrays.sort(tab);

        if (tab.length % 2 == 0) {
            result = (tab[tab.length / 2] + tab[tab.length / 2 - 1]) / 2;
        } else {
            result = tab[tab.length / 2];
        }
        return result;
    }
}
