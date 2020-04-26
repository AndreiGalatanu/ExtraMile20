import java.util.Objects;

public class AdvancedCountry extends Country{
    private final String technology;

    public AdvancedCountry(String name, String capital, long population, long area, String technology) {
        super(name, capital, population, area);
        this.technology = technology;
    }
}
