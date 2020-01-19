package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class GSMArena_iPhoneXSPage {
    private WebDriver driver;

    @FindBy(css = "a[href*='compare.php3']:nth-of-type(1)")
    private WebElement Compare;

    private static String ExpectedTitle = "Apple iPhone XS - Full phone specifications";

    public GSMArena_iPhoneXSPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void AssertPageTitle() {
        String GetPageTitle =  driver.getTitle();
        assertEquals(GetPageTitle, ExpectedTitle);
    }

    public void CompareButton() {
        Compare.click();
    }


}
