package D6_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C1_annotations {
    WebDriver driver;

    @Test @Ignore
    public void googleTest() throws InterruptedException {
        must();
        driver.get("https://www.google.com/");

        String expectedTitle = "google";
        String actualTitle = driver.getCurrentUrl();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title TEST PASSED");
        } else {
            System.out.println("Title TEST FAILED");
        }
       Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void wiseTest() throws InterruptedException {
        must();
        driver.get("https://www.wisequarter.com");

        String expectedTitle = "wise";
        String actualTitle = driver.getCurrentUrl();


        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title TEST PASSED");
        } else {
            System.out.println("Title TEST FAILED");
        }
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void amazonTest()  throws InterruptedException{
        must();
        driver.get("https://www.amazon.com");

        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));


        if (amazonLogo.isDisplayed()) {
            System.out.println("Title TEST PASSED");
        } else {
            System.out.println("Title TEST FAILED");
        }
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
