package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhoneCompare extends DriverLifecycle {

    @FindBy(className = "head-icon icon-mobile-phone231 icon-compare")
    private WebElement Compare;

    @FindBy(id = "sSearch2")
    private WebElement Search;

    @FindBy(id = "sSearch3")
    private WebElement SearchTwo;


}
