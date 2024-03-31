package builder;

import org.openqa.selenium.WebDriver;

public interface Builder {
   Builder setDriver(WebDriver driver);

    Builder setString(String string);

    Builder setInteger(Integer integer);
}
