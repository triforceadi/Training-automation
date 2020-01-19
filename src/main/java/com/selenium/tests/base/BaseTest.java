package com.selenium.tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        driver = factory.createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close driver");
        driver.quit();
    }
}
