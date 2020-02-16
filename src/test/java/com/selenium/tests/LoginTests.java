package com.selenium.tests;

import com.selenium.pages.Sauce_InventoryPage;
import com.selenium.pages.Sauce_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.config.BaseTest;

public class LoginTests extends BaseTest {

    @Test(description = "Testing a valid login info")
    public void ValidLogin() {

        Sauce_LoginPage login = new Sauce_LoginPage(driver);

        login.ValidLogin("standard_user","secret_sauce");

        Sauce_InventoryPage logout = new Sauce_InventoryPage(driver);

        logout.Logout();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://www.saucedemo.com/index.html");
    }

    @Test(description = "Testing an invalid login info")
    public void InvalidLogin() {

        Sauce_LoginPage login = new Sauce_LoginPage(driver);

        login.InvalidLogin("rick","morty");

        Assert.assertTrue(login.InvalidLoginText.isDisplayed());
    }

    @Test(description = "Testing login with a locked out user")
    public void LockedOutLogin() {

        Sauce_LoginPage login = new Sauce_LoginPage(driver);

        login.InvalidLogin("locked_out_user","secret_sauce");

        Assert.assertTrue(login.InvalidLoginText.isDisplayed());
    }
}
