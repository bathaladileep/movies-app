import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MovieDetailsPage;

public class MovieDetailsPageTest {

    public WebDriver driver;

    LoginPage loginPage;
    MovieDetailsPage movieDetailsPage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemakumar\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        movieDetailsPage = new MovieDetailsPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 1)
    public void testHomePageMovieUIElements(){

        movieDetailsPage.clickOnTheHomeMovieDetailsPage();

        String expectedMovieTitle = "Shang-Chi and the Legend of the Ten Rings";

        String actualMovieTitle = movieDetailsPage.getTheMovieTitle();

        Assert.assertEquals(actualMovieTitle, expectedMovieTitle, "movie title does not match");

        String expectedWatchTime = "2h 12m";

        String actualWatchTime = movieDetailsPage.getTheWatchTime();

        Assert.assertEquals(actualWatchTime, expectedWatchTime, "watch time does not match");

        String expectedSensorRating = "U/A";

        String actualSensorRating = movieDetailsPage.getTheSensorRating();

        Assert.assertEquals(actualSensorRating, expectedSensorRating, "sensor rating does not match");

        String expectedReleaseYear = "2021";

        String actualReleaseYear = movieDetailsPage.getTheReleaseYear();

        Assert.assertEquals(actualReleaseYear, expectedReleaseYear, "release year does not match");

        String expectedMovieOverview = "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings";

        String actualMovieOverview = movieDetailsPage.getTheOverview();

        Assert.assertEquals(actualMovieOverview, expectedMovieOverview, "movie overview does not match");

        Assert.assertTrue(movieDetailsPage.checkThePlayButton().isDisplayed(), "play button is not displayed");

    }

    @Test (priority = 2)
    public void testPopularPageMovieUIElements(){

        movieDetailsPage.clickOnPopularLinkPage();

        movieDetailsPage.clickOnThePopularMovieDetailsPage();

        String expectedMovieTitle = "The Amazing Spider-Man";

        String actualMovieTitle = movieDetailsPage.getTheMovieTitle();

        Assert.assertEquals(actualMovieTitle, expectedMovieTitle, "movie title does not match");

        String expectedWatchTime = "2h 43m";

        String actualWatchTime = movieDetailsPage.getTheWatchTime();

        Assert.assertEquals(actualWatchTime, expectedWatchTime, "watch time does not match");

        String expectedSensorRating = "U/A";

        String actualSensorRating = movieDetailsPage.getTheSensorRating();

        Assert.assertEquals(actualSensorRating, expectedSensorRating, "sensor rating does not match");

        String expectedReleaseYear = "2021";

        String actualReleaseYear = movieDetailsPage.getTheReleaseYear();

        Assert.assertEquals(actualReleaseYear, expectedReleaseYear, "release year does not equal");

        String expectedMovieOverview = "Peter Parker is an outcast high schooler abandoned by his parents as a boy, leaving him to be raised by his Uncle Ben and Aunt May.";

        String actualMovieOverview = movieDetailsPage.getTheOverview();

        Assert.assertEquals(actualMovieOverview, expectedMovieOverview, "movie overview does not equal");

        Assert.assertTrue(movieDetailsPage.checkThePlayButton().isDisplayed(), "play button is not displayed");




    }


}
