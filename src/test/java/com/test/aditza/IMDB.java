package com.test.aditza;

import com.test.aditza.base.BaseTest;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.testng.annotations.Test;

public class IMDB extends BaseTest {
    @Test
    public void main() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.imdb.com/");

        Thread.sleep(1000);

        WebElement Search = driver.findElement(By.xpath("/html//input[@id='suggestion-search']"));
        Search.sendKeys("Star Wars");
        Search.sendKeys(Keys.ENTER);

        String BrowserURL = driver.getCurrentUrl();
        Assert.assertTrue(BrowserURL.contains("Star+Wars"));

        try
        {
            WebElement MovieTitle = driver.findElement(By.linkText("Star Wars: Episode IX - The Rise of Skywalker"));
            MovieTitle.click();

        }
        catch(NoSuchElementException e)
        {
            WebElement MoreTitles = driver.findElement(By.linkText("More title matches"));
            MoreTitles.click();
            Thread.sleep(500);
            WebElement TitleMatches = driver.findElement(By.linkText("Star Wars: Episode IX - The Rise of Skywalker"));
            TitleMatches.click();
        }



        WebElement RatingCount = driver.findElement(By.cssSelector("[itemprop='ratingCount']"));
        RatingCount.click();

        WebElement AllAgesScore = driver.findElement(By.xpath("/html//div[@id='main']/section[@class='article listo']/div/table[2]/tbody/tr[2]/td[2]/div[@class='bigcell']"));
        String Score = AllAgesScore.getText();
        String LastKnownScore = "6.9";
        Assert.assertEquals(Score, LastKnownScore);
        System.out.println("Current score is:" + " " + Score + " " + "Last known score is:" + " " + LastKnownScore);



    }

}
