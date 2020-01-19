package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GSMArena_iPhoneXSPage {
    private WebDriver driver;

    @FindBy(css = "a[href*='compare.php3']:nth-of-type(1)")
    private WebElement Compare;


    public GSMArena_iPhoneXSPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void CompareButton() {
        Compare.click();
    }


}
