package D7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C3 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void facebooTest() throws InterruptedException{
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@value=\"1\"])[3]")).click();
        driver.findElement(By.xpath("(//a[@role=\"button\"])[2]")).click();
        WebElement radioButtonMale = driver.findElement(By.xpath("(//input[@class=\"_8esa\"])[2]"));
        WebElement radioButtonFemale = driver.findElement(By.xpath("(//input[@class=\"_8esa\"])[1]"));
        WebElement radioButtonCustom = driver.findElement(By.xpath("(//input[@class=\"_8esa\"])[3]"));

        radioButtonMale.click();
        Assert.assertTrue(radioButtonMale.isSelected());
        Assert.assertFalse(radioButtonFemale.isSelected());
        Assert.assertFalse(radioButtonCustom.isSelected());
    }
}
