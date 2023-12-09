import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import pages.LoginPage;
import pages.AccountsPage;

public class AccountPageTest {

    public WebDriver driver;

    LoginPage loginPage;
    AccountsPage accountsPage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemakumar\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        accountsPage = new AccountsPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 1)
    public void testAccountAllUIElements(){

        accountsPage.clickOnAvatarButton();

        String expectedAccountHeadingText = "Account";

        String actualAccountHeadingText = accountsPage.getTheAccountHeading();

        Assert.assertEquals(actualAccountHeadingText, expectedAccountHeadingText, "account heading text does not match");

        String expectedMembershipHeadingText1 = "Member ship";

        String actualMembershipHeadingText1 = accountsPage.getTheMembershipHeading(0);

        Assert.assertEquals(actualMembershipHeadingText1, expectedMembershipHeadingText1, "membership heading text does not match");

        String expectedMembershipHeadingText2 = "Plan details";

        String actualMembershipHeadingText2 = accountsPage.getTheMembershipHeading(1);

        Assert.assertEquals(actualMembershipHeadingText2, expectedMembershipHeadingText2, "membership heading text does not match");

        String expectedUsernameText = "User name : rahul";

        String actualUsernameText = accountsPage.getTheMembershipUsername();

        Assert.assertEquals(actualUsernameText, expectedUsernameText, "username text does not match");

        String expectedPasswordText = "Password : **********";

        String actualPasswordText = accountsPage.getTheMembershipPassword();

        Assert.assertEquals(actualPasswordText, expectedPasswordText, "password text does not match");

        String expectedPlanParagraph = "Premium";

        String actualPlanParagraph = accountsPage.getThePlanParagraph();

        Assert.assertEquals(actualPlanParagraph, expectedPlanParagraph, "plan paragraph does not match");

        String expectedPlanDetails = "Ultra HD";

        String actualPlanDetails = accountsPage.getThePlanDetails();

        Assert.assertEquals(actualPlanDetails, expectedPlanDetails, "plan details does not match");



    }

    @Test (priority = 2)
    public void testLogoutFunctionality(){

        accountsPage.clickOnAvatarButton();

        Assert.assertTrue(accountsPage.checkTheLogoutButton().isDisplayed(), "logout button is not displayed");

        accountsPage.checkTheLogoutButton().click();

        String loginPageUrl = "https://qamoviesapp.ccbp.tech/login";

        String actualPageUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualPageUrl, loginPageUrl, "url's does not match");





    }
}
