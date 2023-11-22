package D8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C4_Iframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement IframeElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(IframeElement.isDisplayed());
        System.out.println(IframeElement.getText());
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(frameElement);
        WebElement textBoxElement = driver.findElement(By.xpath("//body[@class=\"mce-content-body \"]"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Hello World!");
        driver.switchTo().defaultContent();
        WebElement linkElement = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkElement.isDisplayed());
        System.out.println(linkElement.getText());

        Thread.sleep(5000);


    }
}
