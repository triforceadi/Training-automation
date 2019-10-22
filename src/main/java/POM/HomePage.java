package POM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends DriverLifecycle{

    @FindBy(className = "qc-cmp-button")
    private WebElement Privacy;

    @FindBy(id = "topsearch-text")
    private WebElement Search;

    @FindBy(linkText = "Apple iPhone XS")
    private WebElement Results;

public void SearchPhone(String Results){
    this.Results.clear();
    this.Results.sendKeys("iPhone XS");
}

}
