package com.kopuz.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kopuz.weather.dto.WeatherDto;
import com.kopuz.weather.model.WeatherEntity;
import com.kopuz.weather.repository.WeatherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.kopuz.weather.constant.Constant.API_URL;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WeatherServiceTest {
    private WeatherService weatherService;
    private WeatherRepository weatherRepository;
    private RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        weatherRepository = Mockito.mock(WeatherRepository.class);
        restTemplate = Mockito.mock(RestTemplate.class);
        weatherService = new WeatherService(weatherRepository, restTemplate);
    }

    @Test
    void shouldReturnWeatherEntityWithWeatherDtoByCityName_whenEntityExistInDatabase(){
        String cityName = "New York";
        WeatherEntity cachedWeatherEntity = new WeatherEntity(
                cityName,
                "New York",
                "US",
                Mockito.anyInt(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        when(weatherRepository.findFirstByRequestedCityNameOrderByUpdatedTimeDesc(cityName))
                .thenReturn(Optional.of(cachedWeatherEntity));


        WeatherDto weatherDto = weatherService.getWeatherByCityName(cityName);

        assertNotNull(weatherDto);
        assertEquals(cityName, weatherDto.cityName());
    }
    @AfterEach
    void tearDown() {
    }
}