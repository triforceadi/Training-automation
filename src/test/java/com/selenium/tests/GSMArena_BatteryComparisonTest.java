package com.selenium.tests;

import com.selenium.tests.base.BaseTest;
import com.selenium.pages.GSMArena_HomePage;
import com.selenium.pages.GSMArena_iPhoneXSPage;
import com.selenium.pages.GSMArena_ComparePage;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class GSMArena_BatteryComparisonTest extends BaseTest {

    @Test(priority = 0)
    public void main() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Create object of HomePage class
        GSMArena_HomePage home = new GSMArena_HomePage(driver);

        home.DismissPrivacy();
        home.ClickonSearchBar();
        home.ClickonResult();

        //Assert that we are on the right phone
        String actualTitle = driver.getTitle();
        String expectedTitle = "Apple iPhone XS - Full phone specifications";
        assertEquals(actualTitle, expectedTitle);

        //Create object of the iPhone XS page
        GSMArena_iPhoneXSPage iPhone = new GSMArena_iPhoneXSPage(driver);

        iPhone.CompareButton();

        //Create object of the Compare page
        GSMArena_ComparePage Compare = new GSMArena_ComparePage(driver);

        Compare.SearchforOnePlus();

        Compare.SearchforGalaxy();

        Compare.ClickonDifferences();

        // Move window to the battery row
        js.executeScript("window.scrollBy(0,2500)");

        Compare.CompareiPhoneBattery();
        Compare.CompareOnePlusBattery();
        Compare.CompareSamsungBattery();

    }

}
