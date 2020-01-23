package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class GSMArena_ComparePage {
    private WebDriver driver;

    @FindBy(id = "sSearch2")
    private WebElement SearchRowTwo;

    @FindBy(linkText = "OnePlus 6T")
    private WebElement OnePlus;

    @FindBy(id = "sSearch3")
    private WebElement SearchRowThree;

    @FindBy(linkText = "Samsung Galaxy S10+")
    private WebElement GalaxyS10Plus;

    @FindBy(className = "diff-on")
    private WebElement Differences;

    @FindBy(xpath = "//div[@id='specs-list']/table[12]/tbody/tr[1]/td[2]")
    private WebElement iPhoneBattery;

    @FindBy(xpath = "//div[@id='specs-list']/table[12]/tbody/tr[1]/td[3]")
    private WebElement OnePlusBattery;

    @FindBy(xpath = "//div[@id='specs-list']/table[12]/tbody/tr[1]/td[4]")
    private WebElement SamsungBattery;

    private static String ExpectediPhoneBattery = "Non-removable Li-Ion 2658 mAh battery (10.13 Wh)";
    private static String ExpectedOnePlusBattery = "Non-removable Li-Po 3700 mAh battery";
    private static String ExpectedSamsungBattery = "Non-removable Li-Ion 4100 mAh battery";

    public GSMArena_ComparePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void SearchforOnePlus(String OP) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        SearchRowTwo.click();
        SearchRowTwo.sendKeys(OP);
        wait.until(ExpectedConditions.visibilityOf(OnePlus));
        OnePlus.click();
    }

    public void SearchforGalaxy(String Samsung) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        SearchRowThree.click();
        SearchRowThree.sendKeys(Samsung);
        wait.until(ExpectedConditions.visibilityOf(GalaxyS10Plus));
        GalaxyS10Plus.click();
    }

    public void ClickonDifferences() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Differences);
        actions.perform();
        Differences.click();
    }

    public void CompareiPhoneBattery() {
        String a = iPhoneBattery.getText();
        assertEquals(a, ExpectediPhoneBattery);
    }
    public void CompareOnePlusBattery() {
        String b = OnePlusBattery.getText();
        assertEquals(b, ExpectedOnePlusBattery);
    }
    public void CompareSamsungBattery() {
        String c = SamsungBattery.getText();
        assertEquals(c, ExpectedSamsungBattery);
    }
}
