package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.config.BasePage;


public class Sauce_InventoryPage extends BasePage {
    private WebDriver driver;

    private static String InventoryPage_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(css = "div:nth-of-type(1) > .pricebar > .btn_inventory.btn_primary")
    private WebElement FirstAddToCart;

    @FindBy(css = "div:nth-of-type(1) > .pricebar > .inventory_item_price")
    private WebElement FirstItemPrice;

    @FindBy(css = "div:nth-of-type(2) > .pricebar > .btn_inventory.btn_primary")
    private WebElement SecondAddToCart;

    @FindBy(css = "div:nth-of-type(2) > .pricebar > .inventory_item_price")
    private WebElement SecondItemPrice;

    @FindBy(css = "div:nth-of-type(3) > .pricebar > .btn_inventory.btn_primary")
    private WebElement ThirdAddToCart;

    @FindBy(css = "div:nth-of-type(3) > .pricebar > .inventory_item_price")
    private WebElement ThirdItemPrice;

    @FindBy(css = "div:nth-of-type(4) > .pricebar > .btn_inventory.btn_primary")
    private WebElement FourthAddToCart;

    @FindBy(css = "div:nth-of-type(4) > .pricebar > .inventory_item_price")
    private WebElement FourthItemPrice;

    @FindBy(css = "div:nth-of-type(5) > .pricebar > .btn_inventory.btn_primary")
    private WebElement FifthAddToCart;

    @FindBy(css = "div:nth-of-type(5) > .pricebar > .inventory_item_price")
    private WebElement FifthItemPrice;

    @FindBy(css = "div:nth-of-type(6) > .pricebar > .btn_inventory.btn_primary")
    private WebElement SixthAddToCart;

    @FindBy(css = "div:nth-of-type(6) > .pricebar > .inventory_item_price")
    private WebElement SixthItemPrice;

    @FindBy(xpath = "//div[@id='menu_button_container']//div[@class='bm-burger-button']/button[.='Open Menu']")
    private WebElement BurgerButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement LogoutButton;

    @FindBy(id="shopping_cart_container")
    private WebElement CartButton;


    public Sauce_InventoryPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        driver.get(InventoryPage_URL);
        PageFactory.initElements(driver,this);
    }

    public void Logout() {
        driver.navigate().refresh();
        BurgerButton.click();
        waitForElement(LogoutButton);
        LogoutButton.click();
    }

    public void AddTwoItemsToCart() {
        waitForElement(FirstAddToCart);
        FirstAddToCart.click();
        waitForElement(ThirdAddToCart);
        ThirdAddToCart.click();
    }

    public void AddThreeItemsToCart() {
        waitForElement(SecondAddToCart);
        SecondAddToCart.click();
        waitForElement(FourthAddToCart);
        FourthAddToCart.click();
        waitForElement(FifthAddToCart);
        FifthAddToCart.click();
    }

    public void ClickonCartButton() {
        CartButton.click();
    }

    public void GoBacktoShopping() {
        driver.navigate().back();
        ExpectedURL(InventoryPage_URL);

    }
}
