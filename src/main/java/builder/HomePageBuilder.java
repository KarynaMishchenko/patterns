package builder;
import org.openqa.selenium.WebDriver;
import page.HomePage;
public class HomePageBuilder {
    private WebDriver driver;
    private String string;
    private Integer integer;
    public HomePageBuilder setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }
    public HomePageBuilder setString(String string) {
        this.string = string;
        return this;
    }
    public HomePageBuilder setInteger(Integer integer) {
        this.integer = integer;
        return this;
    }
    public HomePage createHomePage() {
        return new HomePage(driver, string, integer);
    }
}