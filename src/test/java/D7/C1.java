package D7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C1 {
    //before & after
    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void titleTest() {
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void imageTest() {
        WebElement logoItem = driver.findElement(By.xpath("(//yt-icon[@id=\"logo-icon\"])[1]"));
        Assert.assertTrue(logoItem.isDisplayed());

    }

    @Test
    public void searchBoxTest() {
        WebElement searchBoxtem = driver.findElement(By.xpath("//input[@id=\"search\"]"));
        searchBoxtem.isEnabled();

    }

    @Test
    public void wrongTitleTest() {
        String expectedTitle = "youtube";
        String actualTitle = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedTitle, actualTitle);
    }

}
