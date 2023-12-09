import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.List;

import org.testng.Assert;

import pages.LoginPage;
import pages.SearchPage;

public class SearchPageTest {

    public WebDriver driver;

    LoginPage loginPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemakumar\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        searchPage = new SearchPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testSearchFunctionality(){

        searchPage.clickTheSearchEmptyButton();

        searchPage.enterMovieName("venom");

        searchPage.clickTheSearchButton();

        List<WebElement> countMovies = searchPage.getTheMoviesCount();

        Assert.assertEquals(countMovies.size(), 2, "count of movies mismatch");

        System.out.println("Movies Count " + countMovies.size() + " is Displayed");

    }


}
