package com.selenium.tests;

import com.selenium.tests.base.BaseTest;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IMDB extends BaseTest {

    @Test @Ignore
    public void main() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get("https://www.imdb.com/");

        Thread.sleep(500);

        WebElement Search = driver.findElement(By.xpath("/html//input[@id='suggestion-search']"));
        Search.sendKeys("Star Wars");
        Search.sendKeys(Keys.ENTER);

        //Verifying that the search yielded Star Wars results
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

            WebElement TitleMatches = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.linkText("Star Wars: Episode IX - The Rise of Skywalker")));
            TitleMatches.click();
        }


        WebElement RatingCount = driver.findElement(By.cssSelector("[itemprop='ratingCount']"));
        RatingCount.click();

        WebElement AllAgesScore = driver.findElement(By.xpath("/html//div[@id='main']/section[@class='article listo']/div/table[2]/tbody/tr[2]/td[2]/div[@class='bigcell']"));

        //Verifying that the last known score matches the actual score of the title
        String Score = AllAgesScore.getText();
        String LastKnownScore = "6.9";
        Assert.assertEquals(Score, LastKnownScore);
        System.out.println("Current score is:" + " " + Score + " " + "Last known score is:" + " " + LastKnownScore);

    }

}
