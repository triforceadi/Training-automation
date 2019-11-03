import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class Apple {
    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.gsmarena.com/");

        driver.manage().window().maximize();

        Thread.sleep(100);

        WebElement Privacy = driver.findElement(By.xpath("//div[@id='qcCmpButtons']/button[@class='qc-cmp-button']"));
        Privacy.click();

        WebElement Search = driver.findElement(By.id("topsearch-text"));
        Search.click();
        Thread.sleep(100);
        Search.sendKeys("iPhone XS");

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

        js.executeScript("window.scrollBy(0,450)");



    }

}

