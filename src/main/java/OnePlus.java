import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.View;
import java.util.concurrent.TimeUnit;

// As a visitor to the site I should be able to add and remove items from the cart

public class OnePlus {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.oneplus.com/ro");

      //  WebElement Newsletter = driver.findElement(By.cssSelector(".auto-subscribe-dialog .close-hint"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Newsletter = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auto-subscribe-dialog .close-hint")));
                Newsletter.click();

        if (Newsletter.isDisplayed()){
            Newsletter.click();
            System.out.println("The Newsletter was visible");
        }
        else{
            System.out.println("The Newsletter was not visible");
        }

        WebElement StoreBtn = driver.findElement(By.id("family-slide-trigger"));
        StoreBtn.click();

        WebDriverWait waits = new WebDriverWait(driver, 10);
        WebElement DoubleDefence = waits.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".accessory-list-card:nth-child(1) .accessory-image")));
        Actions actions = new Actions(driver);
        actions.moveToElement(DoubleDefence);
        actions.perform();
        DoubleDefence.click();

        WebElement BumperCase = driver.findElement(By.cssSelector(".step:nth-child(2) .acc-info-container"));
        BumperCase.click();


        WebElement KarbonCase = driver.findElement(By.cssSelector(".step:nth-child(2) .acc-item:nth-child(2) .acc-img"));
        KarbonCase.click();

        WebElement ProtectiveCase = driver.findElement(By.cssSelector(".step:nth-child(1) .acc-item-content .acc-img"));
        ProtectiveCase.click();

        WebElement SandstoneCase = driver.findElement(By.cssSelector(".step:nth-child(1) .acc-item:nth-child(2) .acc-img"));
        SandstoneCase.click();

        WebElement AddToCart = driver.findElement(By.linkText("Add to cart "));
        AddToCart.click();

        WebDriverWait cartwait = new WebDriverWait(driver, 10);
        WebElement SeeCart =  cartwait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item > .btn-red")));

        SeeCart.click();

        Thread.sleep(2000);

            String Price = driver.findElement(By.cssSelector("#main_subtotal_B100011201")).getText();
            Assert.assertTrue("43,12 €", Price.contains("43,12 €"));

            if(Price.contains("43,12 €"))
        {
                System.out.println("The price is 43.12 Euros");
            }
        else{
            System.out.println("The price does not match");
        }

    }
}
