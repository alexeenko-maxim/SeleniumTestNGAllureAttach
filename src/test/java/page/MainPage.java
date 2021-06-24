package page;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    String SITE_URL = "https://wooordhunt.ru/word/welcome";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openMainPage() {
        driver.get(SITE_URL);
        return this;
    }

}
