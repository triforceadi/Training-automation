package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.config.BasePage;

public class Sauce_CompleteCheckoutPage extends BasePage {

    private WebDriver driver;

    private static String Complete_URL = "https://www.saucedemo.com/checkout-complete.html";
    public static String ThankYouText = "THANK YOU FOR YOUR ORDER";

    @FindBy(css = "div#checkout_complete_container > .complete-header")
    private WebElement ThankYou;

    public Sauce_CompleteCheckoutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        driver.get(Complete_URL);
        PageFactory.initElements(driver,this);
    }
    public void CompareThankYouTexts() {
        String ActualThankYou = ThankYou.getText();
        Assert.assertEquals(ThankYouText, ActualThankYou);
    }

}
