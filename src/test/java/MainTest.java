import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private CountryService service;

    @BeforeEach
    void setup() {
        service = new CountryService(List.of(

                new Country("Ukraine", "Kiev", 42692393L, 603700L),
                new Country("United Arab Emirates", "Abu Dhabi", 9856000L, 83600L),
                new Country("Romania", "Bucharest", 19861408, 238391)

        ));
    }


    @Test
    @DisplayName("Read all the contries with first Letter")
    void firstLetter() {
        var result = service.getCountriesStartWith("R");
        assertThat(result).contains("Romania");
    }

    @Test
    @DisplayName("Show the capital of the country")
    void showCapital() {
        var result = service.getCapital("Ukraine");
        assertThat(result).contains("Kiev");
    }

    @Test
    @DisplayName("Show Country population")
    void showPopulation() {
        var result = service.getPopulation("United Arab Emirates");
        assertThat(result).contains(9856000L);
    }

    @Test
    @DisplayName("Show Country area")
    void showArea() {
        var result = service.getArea("United Arab Emirates");
        assertThat(result).contains(83600L);

    }

    @Test
    @DisplayName("Show Largest country")
    void LargestCountry() {
        var result = service.getLargestCountry();
        assertThat(result).contains("Ukraine");

    }

    @Test
    @DisplayName("Show Most ppl country")
    void getMostPeopletCountry() {
        var result = service.getMostPeople();
        assertThat(result).contains("Ukraine");

    }

    @Test
    @DisplayName("Show Most Dense")
    void mostDense() {
        var result = service.getMostDense();
        assertThat(result).contains("Ukraine");

    }

    @Test
    @DisplayName("Show Most Present by density lvl")
    void testByDensity() {
        var result = service.getCountryForDensity(DensityLevel.AVERAGE);
        assertThat(result).contains("Ukraine");

    }



    @Test
    @DisplayName("Get country by name")
    void countryByName() {

            assertEquals(new Country("Romania", "Bucharest", 19861408, 238391),new Country("Romania", "Bucharest", 19861408, 238391));

    }
/*
    @Test
    @DisplayName("Get advanced")
    void getAdvenced(){

        service.makeAdvenced("Romania","Technology");
        assertTrue(service.printWithTechnology());


    }
*/

}