package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.config.BasePage;

import java.net.URL;
import java.util.Objects;

public class Sauce_LoginPage extends BasePage {
    private WebDriver driver;

    private static String LoginPage_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement Username;

    @FindBy(id = "password")
    private WebElement Password;

    @FindBy(xpath = "//div[@id='login_button_container']//form/input[@value='LOGIN']")
    private WebElement LoginButton;

    @FindBy(xpath = "//div[@id='login_button_container']//form/h3")
    public WebElement InvalidLoginText;


    public Sauce_LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        driver.get(LoginPage_URL);
        PageFactory.initElements(driver,this);
    }

    public void ValidLogin(String username, String password) {
        waitForElement(Username);
        Username.sendKeys(username);
        waitForElement(Password);
        Password.sendKeys(password);
        LoginButton.click();
    }

    public void InvalidLogin(String username, String password) {
        waitForElement(Username);
        Username.sendKeys(username);
        waitForElement(Password);
        Password.sendKeys(password);
        LoginButton.click();
    }

}
