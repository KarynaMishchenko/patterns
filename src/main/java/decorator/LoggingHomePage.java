package decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePage;

import java.time.Duration;

// Decorator
public class LoggingHomePage extends HomePage {
    public LoggingHomePage(WebDriver driver, String string, Integer integer) {
        super(driver, string, integer);
    }

    // Override existing methods to add logging functionality
    @Override
    public void clickOnSearch() {
        System.out.println("Logging: Clicking on search button");
        super.clickOnSearch();
    }

    @Override
    public HomePage openGoogleCloud() {
        System.out.println("Logging: Opening Google Cloud page");
        return super.openGoogleCloud();
    }

    @Override
    public HomePage enterTextInSearchBar(String string) {
        System.out.println("Logging: Entering text '" + string + "' in search bar");
        return super.enterTextInSearchBar(string);
    }

    @Override
    public void selectCalculator() {
        System.out.println("Logging: Selecting calculator");
        super.selectCalculator();
    }
}
