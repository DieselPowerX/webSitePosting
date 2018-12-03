package pl.konrad.feak_news.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherDto {

    @JsonProperty("main")
    private TempDto tempDto;

    @JsonProperty("clouds")
    private CloudsDto cloudsDto;

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    public static class TempDto {
        @JsonProperty("temp")
        private double temperature;
        public double getTemperature() {
            return temperature - 273.15;
        }
    }

    public static class CloudsDto{
        @JsonProperty("all")
        private int clouds;
        public int getClouds(){
            return clouds;
        }
    }
}