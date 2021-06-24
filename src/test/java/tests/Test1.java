package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.Listener;

@Listeners(Listener.class)
public class Test1 extends BaseTest {

@Attachment


    @Test
    public void findWord() {
        mainPage.openMainPage();
        mainPage.writeText(By.xpath("//input[@type='text']"), "word");
        mainPage.click(By.xpath("//input[@type='submit']"));
        resultPage.checkCorrectResult(By.xpath("//h1[1]"));

    }
}
