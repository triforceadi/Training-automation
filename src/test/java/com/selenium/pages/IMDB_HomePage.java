package com.selenium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDB_HomePage {
    private WebDriver driver;

    private static String HomePage_URL = "https://www.imdb.com/";

	@FindBy(id = "suggestion-search")
	private WebElement SearchBar;

	public IMDB_HomePage(WebDriver driver) {
	    this.driver=driver;
	    driver.get(HomePage_URL);
        PageFactory.initElements(driver, this);
    }

    public void TypeinSearchBar(String text){
	    SearchBar.click();
	    SearchBar.sendKeys(text);

    }
    public void SearchinSearchBar(){
        SearchBar.sendKeys(Keys.ENTER);
    }
}
