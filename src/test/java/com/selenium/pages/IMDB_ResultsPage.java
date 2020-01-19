package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IMDB_ResultsPage {
    private WebDriver driver;

    @FindBy(linkText = "More title matches")
    private WebElement MoreResults;

    @FindBy(linkText = "Star Wars: Episode IX - The Rise of Skywalker")
    private WebElement RiseoftheSkywalker;

    public IMDB_ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void MoreTitles() {
        MoreResults.click();
    }

    public void RiseoftheSkywalker() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(RiseoftheSkywalker));
        RiseoftheSkywalker.click();
    }

}
