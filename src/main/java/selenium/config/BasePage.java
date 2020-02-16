package selenium.config;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    protected WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,TIMEOUT),this);
    }

    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void ExpectedURL(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }
    protected void ScrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
