package D8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C3_BasicAuth extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement textElement = driver.findElement(By.tagName("p"));
        Assert.assertTrue(textElement.isDisplayed());

        Thread.sleep(5000);
    }
}
