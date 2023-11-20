package D7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C4 {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test() {

        WebElement dropdownItem = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select = new Select(dropdownItem);
        int expectedOptionValue = 45;
        int actualOptionValeue = select.getOptions().size();

        Assert.assertEquals(expectedOptionValue, actualOptionValeue);

    }

    @Test
    public void test2() {
        WebElement dropdownItem = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select = new Select(dropdownItem);
        select.selectByVisibleText("Books");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
        WebElement resultItem = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"] )[1]"));
        System.out.println(resultItem.getText());
        String expectedContent = "Java";
        String actualResultText = resultItem.getText();
        Assert.assertTrue(actualResultText.contains(expectedContent));

    }

}
