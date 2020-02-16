package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.config.BasePage;

public class Sauce_CartPage extends BasePage {
    private WebDriver driver;

    private static String CartPage_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(css = ".btn_action.checkout_button")
    private WebElement CheckoutButton;

    @FindBy(css = ".cart_footer .btn_secondary")
    private WebElement ContinueShoppingButton;

    @FindBy(css = ".cart_list > div:nth-of-type(3) .btn_secondary.cart_button")
    private WebElement RemoveFirstItem;

    @FindBy(css = ".cart_list > div:nth-of-type(4) .btn_secondary.cart_button")
    private WebElement RemoveSecondItem;

    @FindBy(css = ".cart_list > div:nth-of-type(5) .btn_secondary.cart_button")
    private WebElement RemoveThirdItem;

    @FindBy(css = ".cart_list > div:nth-of-type(6) .btn_secondary.cart_button")
    private WebElement RemoveFourthItem;

    @FindBy(css = ".cart_list > div:nth-of-type(7) .btn_secondary.cart_button")
    private WebElement RemoveFifthItem;

    @FindBy(css = ".cart_list > div:nth-of-type(8) .btn_secondary.cart_button")
    private WebElement RemoveSixthItem;

    public Sauce_CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        driver.get(CartPage_URL);
        PageFactory.initElements(driver,this);
    }

    public void ClickOnCheckoutButton() {
        CheckoutButton.click();
    }
    public void RemoveTwoItems() {
        ScrollIntoView(RemoveFirstItem);
        waitForElement(RemoveFirstItem);
        RemoveFirstItem.click();
        ScrollIntoView(RemoveThirdItem);
        waitForElement(RemoveThirdItem);
        RemoveThirdItem.click();
    }
    public void RemoveThreeItems() {
        ScrollIntoView(RemoveSecondItem);
        waitForElement(RemoveSecondItem);
        RemoveSecondItem.click();
        ScrollIntoView(RemoveFourthItem);
        waitForElement(RemoveFourthItem);
        RemoveFourthItem.click();
        ScrollIntoView(RemoveFifthItem);
        waitForElement(RemoveFifthItem);
        RemoveFifthItem.click();
    }
}
