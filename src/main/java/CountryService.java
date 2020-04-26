import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public class CountryService {

    private final List<Country> countries;

    public CountryService(List<Country> countries) {
        this.countries = ofNullable(countries)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public List<String> getCountryName() {

        return countries.stream()
                .map(Country::getName)
                .collect(toList());

    }


    public List<String> getCountriesStartWith(String letter) {

        return countries.stream()
                .filter(c -> c.getName().startsWith(letter))
                .map(Country::getName)
                .collect(Collectors.toList());

    }

    public Optional<String> getCapital(String country) {
        return countries.stream()
                .filter(country1 -> country1.getName().equals(country))
                .map(Country::getCapital)
                .findFirst();
    }

    public Optional<Long> getPopulation(String country) {
        return countries.stream()
                .filter(c -> c.getName().equals(country))
                .map(Country::getPopulation)
                .findFirst();
    }

    public Optional<Long> getArea(String country) {
        return countries.stream()
                .filter(c -> c.getName().equals(country))
                .map(Country::getArea)
                .findFirst();
    }

    public String getLargestCountry() {
        return countries.stream()
                .max(Comparator.comparing(Country::getArea))
                .map(Country::getName)
                .get();

    }

    public String getMostPeople() {
        return countries.stream()
                .max(Comparator.comparing(Country::getPopulation))
                .map(Country::getName)
                .get();
    }

    public String getMostDense() {
        return countries.stream()
                .max(Comparator.comparing(Country::getDensity))
                .map(Country::getName)
                .get();
    }

    public List<String> getCountryForDensity(DensityLevel density) {

        return countries.stream()
                .filter(c -> c.getDensity().equals(density))
                .map(Country::getName)
                .collect(toList());

    }

    private Country getCountryByName(String countryName) {

        for (Country country : this.countries) {
            if (country.getName().toLowerCase().equals(countryName.toLowerCase())) {
                return country;
            }

        }
        return null;
    }


    public void makeAdvenced(String countryName, String technology) {
        Country country = getCountryByName(countryName);
        assert country != null;
        Country advencedCountry = new AdvancedCountry(countryName, country.getCapital(), country.getPopulation(), country.getArea(), technology);
        this.countries.set(getCountryPosition(countryName), advencedCountry);
    }

    private int getCountryPosition(String countryName) {
        return this.countries.indexOf(getCountryByName(countryName));
    }

    public void printWithTechnology(){
        for (Country country:this.countries){
            if (country instanceof AdvancedCountry){
                System.out.println(country);
            }
        }
    }


}
