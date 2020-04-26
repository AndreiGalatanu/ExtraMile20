import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountryReader {


    public List<Country> readCountries(String filename) throws FileNotFoundException {

        Scanner scanner = new Scanner(new java.io.FileReader(filename));
        List<Country> result = new ArrayList<>();

        while (scanner.hasNextLine()) {

            result.add(readCountry(scanner.nextLine()));


        }
        return result;


    }

    //-----------------------------------------------------------------//////////////
    public List<Country> readCountriesStream(String filename) throws FileNotFoundException {
        return new BufferedReader(new java.io.FileReader(filename))
                .lines()
                .map(this::readCountry)
                .collect(Collectors.toList());

    }

    private Country readCountry(String line) {
        final String[] tokens = line.split("[|]");

        return new Country(
                tokens[0],
                tokens[1],
                Long.parseLong(tokens[2]),
                Long.parseLong(tokens[3])


        );


    }
}
