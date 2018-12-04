package pl.konrad.feak_news.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherDto {

    @JsonProperty("main")
    private TempDto tempDto;

    @JsonProperty("clouds")
    private CloudsDto cloudsDto;

    @JsonProperty("id")
    private int id;

    @JsonProperty("weather")
    private List<ConditionDto> conditionDto;


    @JsonProperty("name")
    private String name;

    public static class TempDto {
        @JsonProperty("temp")
        private double temperature;
        public String getTemperature() {
            return String.valueOf(Math.round(temperature - 273.15)) + "\u00b0C";
        }
    }

    public static class CloudsDto{
        @JsonProperty("all")
        private int clouds;

        public String getClouds(){
            if(clouds <= 10){
                return"noClouds";
            }else if (clouds <=60){
                return"someClouds";
            }else{
                return"clouds";
            }
        }
    }

    public static class ConditionDto{
        @JsonProperty("main")
        private String state;
        public String getState(){
            return state;
        }
    }
}