package com.selenium.tests;

import com.selenium.tests.base.BaseTest;
import com.selenium.pages.GSMArena_HomePage;
import com.selenium.pages.GSMArena_iPhoneXSPage;
import com.selenium.pages.GSMArena_ComparePage;
import org.openqa.selenium.*;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class GSMArena_BatteryComparisonTest extends BaseTest {

    @Test(groups = {"GSMArena"})
    public void main() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Create object of HomePage class
        GSMArena_HomePage home = new GSMArena_HomePage(driver);

        home.DismissPrivacy();
        home.ClickonSearchBar();
        home.ClickonResult();

        //Create object of the iPhone XS page
        GSMArena_iPhoneXSPage iPhone = new GSMArena_iPhoneXSPage(driver);

        iPhone.AssertPageTitle();

        iPhone.CompareButton();

        //Create object of the Compare page
        GSMArena_ComparePage Compare = new GSMArena_ComparePage(driver);

        Compare.SearchforOnePlus("OnePlus 6T");

        Compare.SearchforGalaxy("Samsung Galaxy S10+");

        Compare.ClickonDifferences();

        // Move window to the battery row
        js.executeScript("window.scrollBy(0,2500)");

        Compare.CompareiPhoneBattery();
        Compare.CompareOnePlusBattery();
        Compare.CompareSamsungBattery();

    }

}

