package D6_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.domsnapshot.model.StringIndex;

import java.time.Duration;

public class C5 {
    WebDriver driver;

    public void must() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void test01() {

        must();
        String expectedURl = "https://www.bestbuy.com";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURl,actualURL);
    }
}
