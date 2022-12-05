package ru.syrnik;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTests {

    @Test
    public void jsonParseTest() throws Exception {
        File file = new File("src/test/resources/json/cars.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Cars cars = objectMapper.readValue(file, Cars.class);
        assertThat(cars.getCars()[0].getMake()).isEqualTo("Chevrolet");
        assertThat(cars.getCars()[1].getHorsepower()).isEqualTo(165);
    }
}
