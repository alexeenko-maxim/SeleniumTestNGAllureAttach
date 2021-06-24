package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    //Wait Wrapper Method  by element located By
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //Click Method by element located By
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Is Element located By  Displayed
    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue((driver.findElement(elementBy).isDisplayed()));
    }
    //Is Element located By  Displayed
    public void checkCorrectResult(By elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue((driver.findElement(elementBy).isDisplayed()));
    }

    public void waitForFilling(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //Write Text in field located By
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    public void isElementNotDisplayed(By elementBy) {
        Assert.assertTrue((driver.findElements(elementBy).isEmpty()));
    }

    public void isAlertText(String message) {
        Assert.assertEquals(message, driver.switchTo().alert().getText());
    }
}
