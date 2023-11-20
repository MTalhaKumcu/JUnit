package D6_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C3_Assertion {
    WebDriver driver;

    @Test

    public void googleTest() throws InterruptedException {
        must();
        driver.get("https://www.google.com/");

        String expectedTitle = "google";
        String actualTitle = driver.getCurrentUrl();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void wiseTest() throws InterruptedException {
        must();
        driver.get("https://www.wisequarter.com");

        String expectedTitle = "wise";
        String actualTitle = driver.getCurrentUrl();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void amazonTest()  throws InterruptedException{
        must();
        driver.get("https://www.amazon.com");

        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(amazonLogo.isDisplayed());

        Thread.sleep(2000);
        driver.close();
    }

    public void must() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


}
