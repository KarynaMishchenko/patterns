package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage{
    protected WebDriver driver;
    @FindBy(xpath="(//a[@track-name='google cloud pricing calculator'])[2]")
    private WebElement calculatorResult;
    @FindBy(css = "div.YSM5S")
    private WebElement searchButton;
    @FindBy(css = "[id='i5']")
    private WebElement searchBar;
    public String string;
    public Integer integer;
    public HomePage(WebDriver driver, String string, Integer integer) {
        this.driver = driver;
        this.string=string;
        this.integer=integer;
        PageFactory.initElements(driver,this);
    }

    public HomePage openGoogleCloud(){
        driver.get("https://cloud.google.com/");
        return this;
    }
    public void clickOnSearch(){
        waitForElementVisibility(searchButton).click();
    }
    public HomePage enterTextInSearchBar(String string){
        waitForElementVisibility(searchBar).sendKeys(string);
        return this;
    }
    public void submitSearch(){
        waitForElementVisibility(searchBar).sendKeys(Keys.ENTER);
    }
    public void selectCalculator(){
        waitForElementVisibility(calculatorResult).click();
    }

    private WebElement waitForElementVisibility(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return locator;
    }
}
