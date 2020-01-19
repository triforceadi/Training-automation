package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class IMDB_MovieTitlePage {
    private WebDriver driver;

    private static String ExpectedTitle = "Star Wars: Episode IX - The Rise of Skywalker (2019) - IMDb";

    public IMDB_MovieTitlePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void AssertPageTitle() {
        String GetPageTitle =  driver.getTitle();
        assertEquals(GetPageTitle, ExpectedTitle);
    }
}
