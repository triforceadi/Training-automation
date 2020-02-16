package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.config.BasePage;

public class Sauce_CheckoutFinalPage extends BasePage {
    private WebDriver driver;

    private static String CheckoutStepTwo_URl = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(css = ".btn_action.cart_button")
    private WebElement Finish;

    @FindBy(css = ".btn_secondary.cart_cancel_link")
    private WebElement CancelFinal;

    @FindBy(css = "[href='\\.\\/inventory-item\\.html\\?id\\=4'] .inventory_item_name")
    private WebElement SauceBackpack;

    @FindBy(css = "[href='\\.\\/inventory-item\\.html\\?id\\=0'] .inventory_item_name")
    private WebElement SauceBikeLight;

    public Sauce_CheckoutFinalPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        driver.get(CheckoutStepTwo_URl);
        PageFactory.initElements(driver,this);
    }

    public void ClickonFinish() {
        ScrollIntoView(Finish);
        waitForElement(Finish);
        Finish.click();
    }
    public void ClickonCancel() {
        ScrollIntoView(CancelFinal);
        waitForElement(CancelFinal);
        CancelFinal.click();
    }
    public void AssertTwoItemsPresent() {
        Assert.assertTrue(SauceBackpack.isDisplayed());
        Assert.assertTrue(SauceBikeLight.isDisplayed());
    }

}
