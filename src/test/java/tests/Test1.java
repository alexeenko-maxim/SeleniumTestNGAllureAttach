package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {

    @Test
    public void findWord() {
        mainPage.openMainPage();
        mainPage.writeText(By.xpath("//input[@type='text']"), "word");
        mainPage.click(By.xpath("//input[@type='submit']"));
        resultPage.checkCorrectResult(By.xpath("//h1[1]"));

    }
}
