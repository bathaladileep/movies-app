import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest {

    public WebDriver driver;

    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemakumar\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }


    @Test (priority = 1)
    public void testLoginPageUI(){

        Assert.assertTrue(loginPage.findWebsiteLogoImage().isDisplayed(), "website logo image not displayed");

        String expectedLoginHeadingText = "Login";

        String actualLoginHeadingText = loginPage.getTheLoginHeadingText();

        Assert.assertEquals(actualLoginHeadingText, expectedLoginHeadingText, "heading text does not match");

        String expectedUsernameLabelText = "USERNAME";

        String actualUsernameLabelText = loginPage.getTheLabelText(0);

        Assert.assertEquals(actualUsernameLabelText, expectedUsernameLabelText, "username label text does not match");

        String expectedPasswordLabelText = "PASSWORD";

        String actualPasswordLabelText = loginPage.getTheLabelText(1);

        Assert.assertEquals(actualPasswordLabelText, expectedPasswordLabelText, "password label text does not match");

        Assert.assertTrue(loginPage.findTheLoginButton().isDisplayed(), "login button is not displayed");


    }


    @Test (priority = 2)
    public void testLoginFunctionalitiesWithEmptyInputFields(){

        loginPage.loginToApplication("", "");

        String expectedErrorMsgText = "*Username or password is invalid";

        String actualErrorMessageText = loginPage.getTheErrorMsg();

        Assert.assertEquals(actualErrorMessageText, expectedErrorMsgText, "error message does not match");

    }

    @Test (priority = 3)
    public void testLoginFunctionalityWithEmptyUsername(){

        loginPage.loginToApplication("", "rahul@2021");

        String expectedErrorMsgText = "*Username or password is invalid";

        String actualErrorMessageText = loginPage.getTheErrorMsg();

        Assert.assertEquals(actualErrorMessageText, expectedErrorMsgText, "error message does not match");

    }

    @Test (priority = 4)
    public void testLoginFunctionalityWithEmptyPassword(){

        loginPage.loginToApplication("rahul", "");

        String expectedErrorMsgText = "*Username or password is invalid";

        String actualErrorMessageText = loginPage.getTheErrorMsg();

        Assert.assertEquals(actualErrorMessageText, expectedErrorMsgText, "error message does not match");

    }

    @Test (priority = 5)
    public void testLoginFunctionalityWithInvalidCredentials(){

        loginPage.loginToApplication("rahul", "rahul@2022");

        String expectedErrorMsgText = "*username and password didn't match";

        String actualErrorMessageText = loginPage.getTheErrorMsg();

        Assert.assertEquals(actualErrorMessageText, expectedErrorMsgText, "error message does not match");

    }

    @Test (priority = 6)
    public void testLoginFunctionalityWithValidCredentials(){

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedHomePageUrl = "https://qamoviesapp.ccbp.tech/login";

        String currentHomePageUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentHomePageUrl, expectedHomePageUrl, "Url's does not match");


    }


}
