package D9_switchingWindow_actions;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C1 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String expectedAmazonTitle = "Amazon";
        String amazonWHD = driver.getWindowHandle();
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedAmazonTitle));
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get("https://www.instagram.com");
        String instagramWHD = driver.getWindowHandle();
        expectedAmazonTitle = "instagram";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedAmazonTitle));
        driver.switchTo().window(amazonWHD);
        expectedAmazonTitle = "amazon";
        actualURL=driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedAmazonTitle));
        Thread.sleep(2000);
    }
}

