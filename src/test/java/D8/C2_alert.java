package D8;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClass;

public class C2_alert extends TestBaseBeforeClass {


    //https://the-internet.herokuapp.com/javascript_alerts
    /*
    otomasyon yaparken iki tur alert ile karsilasabiliriz
    1-HTML alert=> HTML codeleriyla olusuturulmustur.HTML ile olusturuldugu icin inspect edilebilir, locaete edilebilir ve driver ile kullanilabilir
    2-JS alerts => inspect yapilamaz locate edilemez.JS alert ile karsilasirsak "driver.switchTo().alert"
                methodlarini kullanarak alert`e gecis yapabilir ve alerrt uzerinde OK,Cancel ,alert yazisini
                alma getText() ve alert`e yazi yollama sendKeys() methodlarini kullanabiliriz.

     */
    @Test
    @Ignore
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();

        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();
        Thread.sleep(2000);
        Assert.assertEquals(expectedAlertText, actualAlertText);

        driver.switchTo().alert().accept();
    }

    @Test
    @Ignore
    public void test2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        String expectedAlertText = "You clicked: Cancel";
        String actualAlertText = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        Thread.sleep(2100);
        Assert.assertEquals(expectedAlertText, actualAlertText);
    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        Thread.sleep(2100);
        driver.switchTo().alert().sendKeys("abdullah");
        driver.switchTo().alert().accept();
        Thread.sleep(2100);
        String expectedText = "abdullah";
        Thread.sleep(2100);
        String actualTExt = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        Assert.assertTrue(actualTExt.contains(expectedText));

    }

}

