package com.test.aditza;

import com.test.aditza.base.BaseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class Apple extends BaseTest {
    @Test
    public void main() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.gsmarena.com/");


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Privacy = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='qcCmpButtons']/button[@class='qc-cmp-button']")));
                Privacy.click();

        WebElement Search = driver.findElement(By.id("topsearch-text"));
        Search.click();
        Thread.sleep(100);
        Search.sendKeys("iPhone XS");

        Thread.sleep(1000);

        WebElement Results = driver.findElement(By.linkText("Apple iPhone XS"));
        Results.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Apple iPhone XS - Full phone specifications";
        assertEquals(actualTitle, expectedTitle);

        WebElement Compare = driver.findElement(By.cssSelector("a[href*='compare.php3']:nth-of-type(1)"));
        Compare.click();

        WebElement OnePlus = driver.findElement(By.id("sSearch2"));
        OnePlus.click();
        OnePlus.sendKeys("OnePlus 6T");

        WebElement OP6T = driver.findElement(By.linkText("OnePlus 6T"));
        OP6T.click();

        WebElement Galaxy = driver.findElement(By.id("sSearch3"));
        Galaxy.click();
        Galaxy.sendKeys("Samsung Galaxy S10+");

        WebElement GalaxyClick = driver.findElement(By.linkText("Samsung Galaxy S10+"));
        GalaxyClick.click();

        WebElement Differences = driver.findElement(By.className("diff-on"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Differences);
        actions.perform();
        Differences.click();

        js.executeScript("window.scrollBy(0,500)");

        String iPhoneBattery = driver.findElement(By.xpath("//div[@id='specs-list']/table[12]/tbody/tr[1]/td[2]")).getText();
        String ExpectediPBattery = "Non-removable Li-Ion 2658 mAh battery (10.13 Wh)";
        assertEquals(iPhoneBattery, ExpectediPBattery);


        String OnePlusBattery = driver.findElement(By.xpath("//div[@id='specs-list']/table[12]/tbody/tr[1]/td[3]")).getText();
        String ExpectedOPBattery = "Non-removable Li-Po 3700 mAh battery";
        assertEquals(OnePlusBattery, ExpectedOPBattery);


        String SamsungBattery = driver.findElement(By.xpath("//div[@id='specs-list']/table[12]/tbody/tr[1]/td[4]")).getText();
        String ExpectedSMBattery = "Non-removable Li-Ion 4100 mAh battery";
        assertEquals(SamsungBattery, ExpectedSMBattery);


    }

}

