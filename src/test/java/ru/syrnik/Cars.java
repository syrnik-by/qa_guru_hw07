package ru.syrnik;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cars {

    private Car[] cars;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Car {
        private String make;
        private String model;

        @JsonSetter("Miles_per_Gallon")
        private int miles_per_Gallon;
        @JsonSetter("Cylinders")
        private int cylinders;
        @JsonSetter("Displacement")
        private int displacement;
        @JsonSetter("Horsepower")
        private int horsepower;
        @JsonSetter("Weight_in_lbs")
        private int weight_in_lbs;
        @JsonSetter("Acceleration")
        private int acceleration;
        @JsonSetter("Year")
        private String year;
        @JsonSetter("Origin")
        private String origin;
    }
}
