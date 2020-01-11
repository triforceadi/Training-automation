package com.test.aditza;

import com.test.aditza.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Altex extends BaseTest {

    @Test(priority = 3) @Ignore
    public void main() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.altex.ro");


        WebElement SearchBar = driver.findElement(By.xpath("/html//div[@id='SearchContainer']//input"));
        SearchBar.sendKeys("iPhone 11 Pro");

        WebElement SearchButton = driver.findElement(By.xpath("/html//div[@id='SearchContainer']//button[@title='Cautare']"));
        SearchButton.click();

        WebElement GoldiPhone = driver.findElement(By.linkText("Telefon APPLE iPhone 11 Pro, 64GB, Silver"));
        GoldiPhone.click();

        WebElement iPhonePrice = driver.findElement(By.cssSelector("[class='u-border-b-dotted u-space-pb-10 mb-2'] .Price-int"));
        String GoldPrice = iPhonePrice.getText();
        System.out.println("Price of the iPhone is:"  + GoldPrice);

        js.executeScript("window.scrollBy(0,100)");

        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement addToCart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bg-secondary.border-2.border-r.border-transparent.flex.flex-none.items-center.justify-center.rounded-l.text-black.text-white > .fill-current")));
        addToCart.click();

        Thread.sleep(1000);


        /*

        WebElement backBuyButton = driver.findElement(By.cssSelector(".bg-white.group.inline-block.leading-none.rounded.text-black.text-usm .flex.items-center.justify-center"));
        backBuyButton.click();

         SearchBar.sendKeys("CAT S31");
        Thread.sleep(1000);
        SearchButton.click();



        WebElement CAT = driver.findElement(By.linkText("Telefon CAT S31, 16GB. 2GB RAM, IP68, Dual SIM, Black"));
        CAT.click();

        WebElement CATPrice = driver.findElement(By.cssSelector("[class='u-border-b-dotted u-space-pb-10 mb-2'] .Price-int"));
        String MeowPrice = CATPrice.getText();
        System.out.println(MeowPrice);

        WebElement addToCartCAT = driver.findElement(By.cssSelector("[class='border-2 rounded-r flex-grow p-1 border-transparent'] .justify-center"));
        addToCartCAT.click();

        Thread.sleep(1000);
        */

        driver.get("https://altex.ro/cos-cumparaturi/");

        Thread.sleep(1000);

        WebElement TotalPrice = driver.findElement(By.xpath("/html//div[@id='checkout']/div/section/div[@class='Cart u-space-mb-20']/div//span[@class='Price-int']"));
        String TotalStringPrice = TotalPrice.getText();

                    assertEquals(TotalStringPrice, GoldPrice);

        }





    }
