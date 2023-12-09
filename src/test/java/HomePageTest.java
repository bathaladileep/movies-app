import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.Assert;

import pages.LoginPage;
import pages.HomePage;

public class HomePageTest {

    public WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemakumar\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test (priority = 1)
    public void testHomePageUI(){

        String actualFirstSectionHeadingText = "Trending Now";

        String expectedFirstSectionHeadingText = homePage.getTheSectionHeadingText(0);

        Assert.assertEquals(actualFirstSectionHeadingText, expectedFirstSectionHeadingText, "section heading texts does not match");

        String actualSecondSectionHeadingText = "Originals";

        String expectedSecondSectionHeadingText = homePage.getTheSectionHeadingText(1);

        Assert.assertEquals(actualSecondSectionHeadingText, expectedSecondSectionHeadingText, "section heading texts does not match");

        Assert.assertTrue(homePage.findThePlayButton().isDisplayed(), "play button is not displayed");

        Assert.assertTrue(homePage.moviesDisplayedOrNot().isDisplayed(), "list of movies is not displayed");

    }


    @Test (priority = 2)
    public void testContactUsSection(){

        Assert.assertTrue(homePage.findContactUsGoggleIcon().isDisplayed(), "goggle icon is not displayed");

        Assert.assertTrue(homePage.findContactUsTwitterIcon().isDisplayed(), "twitter icon is not displayed");

        Assert.assertTrue(homePage.findContactUsInstagramIcon().isDisplayed(), "instagram icon is not displayed");

        Assert.assertTrue(homePage.findContactUsYoutubeIcon().isDisplayed(), "youtube icon is not displayed");

        String actualContactUsText = "Contact Us";

        String expectedContactUsText = homePage.getTheContactUsText();

        Assert.assertEquals(actualContactUsText, expectedContactUsText, "contactUs text does not match");




    }
}
