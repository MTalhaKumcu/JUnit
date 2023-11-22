package D9_switchingWindow_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C5 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        WebElement dragMeElement = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        ;
        WebElement dragHereElement = driver.findElement(By.xpath("(//div[@id=\"droppable\"] )[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement, dragHereElement).perform();
        Thread.sleep(2000);

        WebElement droppedElement = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        String expectedText = "Dropped!";
        String actualText = droppedElement.getText();
        Assert.assertEquals(expectedText, actualText);

        Thread.sleep(2000);

    }

}
