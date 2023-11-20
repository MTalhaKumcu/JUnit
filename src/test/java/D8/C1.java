package D8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C1 extends TestBase {
    //once @before yada @Afte`i control eder.(hem basta hem sonda)
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        String expectedItem = "Nutella";
        String actualSearchText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        Assert.assertTrue(actualSearchText.contains(expectedItem));

    }
    //once @before yada @Afte`i control eder.(hem basta hem sonda)
    //bunun icin inheritance yapilacak

}
