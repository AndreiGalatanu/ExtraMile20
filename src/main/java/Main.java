import java.io.FileNotFoundException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final List<Country> countries= new CountryReader().readCountriesStream("src\\main\\resources\\countries");
Country country= new Country("sda","dasd",3123312L,23123L);
        CountryService service= new CountryService(countries);

     //   System.out.println(service.getCountryName());
        service.makeAdvenced("Romania","tehnology");
        service.printWithTechnology();


    }
}
