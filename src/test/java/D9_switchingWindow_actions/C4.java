package D9_switchingWindow_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C4 extends TestBase {
    @Test
    public void tes1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstWHD = driver.getWindowHandle();
        WebElement areaElement = driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"));
        Actions actions = new Actions(driver);

        actions.contextClick(areaElement).perform();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        String secWHD = "";
        Set<String> WHDs = driver.getWindowHandles();
        for (String eachWHD : WHDs
        ) {
            if (eachWHD.equals(firstWHD)) {
                secWHD = eachWHD;
            }
        }
        driver.switchTo().window(secWHD);
        String expectedText = "Elemental Selenium";
        WebElement textElement = driver.findElement(By.tagName("h1"));
        String actualtText = textElement.getText();
        Assert.assertEquals(expectedText,actualtText);
        Thread.sleep(3000);
    }
}
