package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void checkCorrectResult(By elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue((driver.findElement(elementBy).isDisplayed() & driver.findElement(elementBy).getText().equals("word")));
    }
}
