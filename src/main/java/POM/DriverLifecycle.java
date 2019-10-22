package POM;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class DriverLifecycle {
    protected static WebDriver driver;

  @BeforeClass
    public static void setUp(){
      WebDriver driver = new ChromeDriver();
      JavascriptExecutor js = (JavascriptExecutor) driver;
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @After
    public void cleanUp(){
      driver.manage().deleteAllCookies();
  }

  @AfterClass
    public static void tearDown() {
      driver.close();
  }

}
