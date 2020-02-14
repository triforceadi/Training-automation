package com.selenium.tests;

import com.selenium.pages.IMDB_HomePage;
import com.selenium.pages.IMDB_MovieTitlePage;
import com.selenium.pages.IMDB_ResultsPage;
import org.testng.Assert;
import selenium.config.BaseTest;
import org.testng.annotations.Test;


public class IMDB_StarWarsTest extends BaseTest {

    @Test(groups = {"IMDB"})
    public void main() {

        //Create object of HomePage class
        IMDB_HomePage home = new IMDB_HomePage(driver);
        home.TypeinSearchBar("Star Wars");
        home.SearchinSearchBar();

        //Verifying that the search yielded Star Wars results
        String BrowserURL = driver.getCurrentUrl();
        Assert.assertTrue(BrowserURL.contains("Star+Wars"));

        //Create object of results class
        IMDB_ResultsPage results = new IMDB_ResultsPage(driver);
        results.MoreTitles();
        results.RiseoftheSkywalker();

        //Create object of movie title class
        IMDB_MovieTitlePage movie = new IMDB_MovieTitlePage(driver);
        movie.AssertPageTitle();
    }

}
