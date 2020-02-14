package com.selenium.tests;

import com.selenium.pages.GSMArena_FailedLoginPage;
import com.selenium.pages.GSMArena_HomePage;
import selenium.config.BaseTest;
import org.testng.annotations.Test;

public class GSMArena_NegativeLoginTest extends BaseTest {

    @Test(groups = {"GSMArena"})
    public void main() {

        //Create object of HomePage class
        GSMArena_HomePage home = new GSMArena_HomePage(driver);

        home.DismissPrivacy();

        home.ClickonLoginIcon();

        //Sending the email and password
        home.SendEmail("thisshouldnotwork@gmail.com");
        home.SendPassword("thishsouldnotwork");

        home.SubmitData();

        //Create object of FailedLogin page class
        GSMArena_FailedLoginPage login = new GSMArena_FailedLoginPage(driver);

        login.FailedLoginCheck();






    }

}
