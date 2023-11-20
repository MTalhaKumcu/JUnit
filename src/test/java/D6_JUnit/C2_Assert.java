package D6_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C2_Assert {
    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://amazon.com");

        String expectedContent ="amazon";
        String actualUrl = driver.getTitle();
/*
        if (actualUrl.contains(expectedContent)){
            System.out.println("Test TEST PASSED");
        }else {
            System.out.println("Test TEST FAILED");
        }
*/


        Assert.assertTrue(actualUrl.contains(expectedContent));

        Thread.sleep(2000);
        driver.close();



    }
}
