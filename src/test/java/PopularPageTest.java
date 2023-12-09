import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.Assert;

import pages.LoginPage;
import pages.PopularPage;

import java.util.List;

public class PopularPageTest {

    public WebDriver driver;

    LoginPage loginPage;
    PopularPage popularPage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemakumar\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        popularPage = new PopularPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testPopularPageUI(){

        popularPage.navigateToThePopularLink();

        List<WebElement> listOfMovies = popularPage.listOfTheMoviesDisplayed();

        Assert.assertEquals(listOfMovies.size(), 30, "list of movies mismatch");

    }
}




