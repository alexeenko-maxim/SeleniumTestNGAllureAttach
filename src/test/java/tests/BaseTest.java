package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page.MainPage;
import page.ResultPage;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public MainPage mainPage;
    public ResultPage resultPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void start(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions Options = new ChromeOptions();
        Options.setHeadless(true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        resultPage = PageFactory.initElements(driver, ResultPage.class);
    }
    @AfterTest
    public void stop(){
        driver.quit();
    }





}
