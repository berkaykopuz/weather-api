package com.kopuz.weather.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    public static String API_URL;
    public static String ACCESS_PARAM = "?access_key=";
    public static String API_KEY;
    public static String QUERY_PARAM = "&query=";
    @Value("${weather-stack.api-url}")
    public void setApiUrl(String apiUrl){
        Constant.API_URL = apiUrl;
    }
    @Value("${weather-stack.api-key}")
    public void setApiKey(String apiKey){
        Constant.API_KEY = apiKey;
    }

}