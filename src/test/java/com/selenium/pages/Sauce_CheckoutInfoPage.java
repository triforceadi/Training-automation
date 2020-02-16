package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.config.BasePage;

public class Sauce_CheckoutInfoPage extends BasePage {
    private WebDriver driver;

    private static String CheckoutStepOne_URL = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(id = "first-name")
    private WebElement FirstName;

    @FindBy(id = "last-name")
    private WebElement LastName;

    @FindBy(id = "postal-code")
    private WebElement PostalCode;

    @FindBy(css = ".btn_secondary.cart_cancel_link")
    private WebElement Cancel;

    @FindBy(css = ".btn_primary.cart_button")
    private WebElement Continue;

    @FindBy(xpath = "//div[@id='checkout_info_container']//form/h3")
    private WebElement MissingPostalCode;

    public Sauce_CheckoutInfoPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        driver.get(CheckoutStepOne_URL);
        PageFactory.initElements(driver,this);
    }

    public void FillFirstNameWith(String firstname) {
        waitForElement(FirstName);
        FirstName.click();
        FirstName.sendKeys(firstname);
    }
    public void FillLastNameWith(String lastname) {
        waitForElement(LastName);
        LastName.click();
        LastName.sendKeys(lastname);
    }
    public void FillPostalCodeWith(String zip) {
        waitForElement(PostalCode);
        PostalCode.click();
        PostalCode.sendKeys(zip);
    }
    public void BackToCart() {
        Cancel.click();
    }
    public void Continue() {
        Continue.click();
    }
    public void AssertZipErrorMessage() {
        waitForElement(MissingPostalCode);
        Assert.assertTrue(MissingPostalCode.isDisplayed());
    }



}
