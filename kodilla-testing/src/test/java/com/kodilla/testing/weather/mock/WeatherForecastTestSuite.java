package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    private static WeatherForecast weatherForecast;
    private static final Map<String, Double> temperaturesMap = new HashMap<>();

    @Mock
    private Temperatures temperaturesMock;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Begining of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Prepering to execute test #" + testCounter);

        temperaturesMap.clear();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }

    @Test
    void testCalculateForecastWithMock() {
        System.out.println("Test Calculate Forecast With Mock");
        //Given
        weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5, quantityOfSensors);
    }

    @Test
    void testAverageTemoeratureWithMock() {
        System.out.println("Test Average Temoerature With Mock");
        //Given
        weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        //When
        double averageTemperatureResult = weatherForecast.averageTemperature();
        //Then
        assertEquals(25.56, averageTemperatureResult);
    }

    @Test
    void testMedianTemperatureWithMock() {
        System.out.println("Test Median Temperature With Mock");
        //Given
        weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        //When
        double medianTemperatureResult = weatherForecast.medianTemperature();
        //Then
        assertEquals(25.5, medianTemperatureResult);
    }
}
