package com.selenium.tests;

import com.selenium.pages.*;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import selenium.config.BaseTest;


public class CheckoutTests extends BaseTest {


    @Test(description = "Testing a valid checkout path")
    public void ValidCheckout() {

        Sauce_LoginPage login = new Sauce_LoginPage(driver);
        login.ValidLogin("standard_user","secret_sauce");

        Sauce_InventoryPage inventory = new Sauce_InventoryPage(driver);
        inventory.AddTwoItemsToCart();
        inventory.ClickonCartButton();
        inventory.GoBacktoShopping();
        inventory.AddThreeItemsToCart();
        inventory.ClickonCartButton();

        Sauce_CartPage cart = new Sauce_CartPage(driver);
        cart.ClickOnCheckoutButton();

        Sauce_CheckoutInfoPage checkoutone = new Sauce_CheckoutInfoPage(driver);
        checkoutone.FillFirstNameWith("Dorel");
        checkoutone.FillLastNameWith("Gigel");
        checkoutone.FillPostalCodeWith("061123");
        checkoutone.Continue();

        Sauce_CheckoutFinalPage checkoutfinal = new Sauce_CheckoutFinalPage(driver);
        checkoutfinal.ClickonFinish();

        Sauce_CompleteCheckoutPage thankyoupage = new Sauce_CompleteCheckoutPage(driver);
        thankyoupage.CompareThankYouTexts();

    }

    @Test(description = "Testing an invalid checkout path")
    public void InvalidCheckoutInfo() {
        Sauce_LoginPage login = new Sauce_LoginPage(driver);
        login.ValidLogin("standard_user","secret_sauce");

        Sauce_InventoryPage inventory = new Sauce_InventoryPage(driver);
        inventory.AddTwoItemsToCart();
        inventory.ClickonCartButton();
        inventory.GoBacktoShopping();
        inventory.AddThreeItemsToCart();
        inventory.ClickonCartButton();

        Sauce_CartPage cart = new Sauce_CartPage(driver);
        cart.ClickOnCheckoutButton();

        Sauce_CheckoutInfoPage checkoutone = new Sauce_CheckoutInfoPage(driver);
        checkoutone.FillFirstNameWith("Dorel");
        checkoutone.FillLastNameWith("Gigel");
        checkoutone.Continue();
        checkoutone.AssertZipErrorMessage();
    }
    @Test(description = "Testing a checkout after removing items")
    public void ValidCheckoutAfterRemovingItems() {
        Sauce_LoginPage login = new Sauce_LoginPage(driver);
        login.ValidLogin("standard_user","secret_sauce");

        Sauce_InventoryPage inventory = new Sauce_InventoryPage(driver);
        inventory.AddTwoItemsToCart();
        inventory.ClickonCartButton();
        inventory.GoBacktoShopping();
        inventory.AddThreeItemsToCart();
        inventory.ClickonCartButton();

        Sauce_CartPage cart = new Sauce_CartPage(driver);
        cart.RemoveThreeItems();
        cart.ClickOnCheckoutButton();

        Sauce_CheckoutInfoPage checkoutone = new Sauce_CheckoutInfoPage(driver);
        checkoutone.FillFirstNameWith("Dorel");
        checkoutone.FillLastNameWith("Mirabela");
        checkoutone.FillPostalCodeWith("061164");
        checkoutone.Continue();

        Sauce_CheckoutFinalPage checkoutfinal = new Sauce_CheckoutFinalPage(driver);
        checkoutfinal.AssertTwoItemsPresent();
        checkoutfinal.ClickonFinish();

        Sauce_CompleteCheckoutPage thankyoupage = new Sauce_CompleteCheckoutPage(driver);
        thankyoupage.CompareThankYouTexts();

    }
}
