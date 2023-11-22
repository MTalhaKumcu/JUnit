package D9_switchingWindow_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C2 extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement openingWindowElement = driver.findElement(By.tagName("h3"));

        String expectedText = "Opening a new window";
        String actualText = openingWindowElement.getText();

        Assert.assertEquals(expectedText, actualText);

        String firstPageWHD = driver.getWindowHandle();

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        driver.findElement(By.xpath("//*[text()=\"Click Here\"]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        String secWHD = "";

        for (String eachWHD : windowHandles) {


            if (eachWHD.equals(firstPageWHD)) {
                secWHD = eachWHD;
            }
        }
        driver.switchTo().window(secWHD);

         expectedTitle = "New Window";
         actualTitle = driver.getTitle();
         Assert.assertEquals(expectedText,actualText);

         WebElement nwText= driver.findElement(By.tagName("h3"));
         expectedTitle = "New Window";
         actualTitle = nwText.getText();;
         Assert.assertEquals(expectedText,actualText);

         driver.switchTo().window(firstPageWHD);



        /*
        driver.switchto()newWindow kullanarak driver otomatik olarak gecer
        Ancak
            bir link tikladigimizda biz newwindow method`unu kullamadan
            bir link tikladigimizda yeni window aciliyorsa driver eski
            window`da kalir .
            Yeni window`a driver`i gecirebilmek icin yeni window`un windowhandle()
            degerine ihtiyacimiz vardir.

         */
    }
}
