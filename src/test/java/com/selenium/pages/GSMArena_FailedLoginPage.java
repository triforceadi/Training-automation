package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;


public class GSMArena_FailedLoginPage {

    private WebDriver driver;

    @FindBy(xpath = "/html//div[@id='body']//h3[.='Login failed.']")
    private WebElement FailedLoginHeader;

    private static String FailMessage = "Login failed.";

    public GSMArena_FailedLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void FailedLoginCheck() {
        String Fail = FailedLoginHeader.getText();
        assertEquals(Fail, FailMessage);
        System.out.println(Fail);

    }
}
