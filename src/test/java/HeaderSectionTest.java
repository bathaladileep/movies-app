import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.Assert;

import pages.LoginPage;
import pages.HeaderSectionPage;

public class HeaderSectionTest {

    public WebDriver driver;

    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemakumar\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        headerSectionPage = new HeaderSectionPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 1)
    public void testHeaderSectionUI(){

        Assert.assertTrue(headerSectionPage.findTheHeaderWebsiteLogo().isDisplayed(), "header website logo is not displayed");

        Assert.assertTrue(headerSectionPage.findTheHomeLink().isDisplayed(), "home link is not displayed");

        Assert.assertTrue(headerSectionPage.findThePopularLink().isDisplayed(), "popular link is not displayed");

        Assert.assertTrue(headerSectionPage.findTheSearchField().isDisplayed(), "search field is not displayed");

        Assert.assertTrue(headerSectionPage.findTheAccountAvatarButton().isDisplayed(), "account details button is not displayed");


    }

    @Test (priority = 2)
    public void testHeaderSectionFunctionalities(){

        headerSectionPage.clickTheHomeLink();

        String expectedHomeLinkUrl = "https://qamoviesapp.ccbp.tech/";

        String currentHomeLinkUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentHomeLinkUrl, expectedHomeLinkUrl, "home link url does not match");

        headerSectionPage.clickThePopularLink();

        String expectedPopularLinkUrl = "https://qamoviesapp.ccbp.tech/popular";

        String currentPopularLinkUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentPopularLinkUrl, expectedPopularLinkUrl, "popular link url does not match");

        headerSectionPage.clickAccountSection();

        String expectedAccountSectionUrl = "https://qamoviesapp.ccbp.tech/account";

        String currentAccountSectionUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentAccountSectionUrl, expectedAccountSectionUrl, "account section url does not match");


    }
}




