package com.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class GSMArena_HomePage {
    private WebDriver driver;

    private static String HomePage_URL = "https://www.gsmarena.com/";

    @FindBy(xpath = "//div[@id='qcCmpButtons']/button[@class='qc-cmp-button']")
    private WebElement PrivacyPopup;

    @FindBy(id = "topsearch-text")
    private WebElement SearchBar;

    @FindBy(xpath = "/html//form[@id='topsearch']//div[@class='phone-results']/ul//a[@href='apple_iphone_xs-9318.php']")
    private WebElement iPhoneResult;

    @FindBy(id = "login-active")
    private WebElement LoginIcon;

    @FindBy(id = "email")
    private WebElement EmailField;

    @FindBy(id = "upass")
    private WebElement PasswordField;

    @FindBy(id = "nick-submit")
    private WebElement SubmitLogin;

    @FindBy(id = "login-popup2")
    private WebElement LoginPopup;

    public GSMArena_HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(HomePage_URL);
        PageFactory.initElements(driver, this);
    }

    public void DismissPrivacy() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(PrivacyPopup));
        PrivacyPopup.click();
    }
    public void ClickonSearchBar() {
        SearchBar.click();
        SearchBar.sendKeys("iPhone XS");

    }
    public void ClickonResult() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(iPhoneResult));
        iPhoneResult.click();
    }

    public void ClickonLoginIcon() {
        LoginIcon.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(LoginPopup));

    }
    public void SendEmail(String email) {
        EmailField.clear();
        EmailField.sendKeys(email);
    }
    public void SendPassword(String password) {
        PasswordField.clear();
        PasswordField.sendKeys(password);
    }
    public void SubmitData() {
        SubmitLogin.click();
    }
}
