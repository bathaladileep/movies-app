package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountsPage {

    WebDriver driver;
    WebDriverWait wait;

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By clickOnAvatarButtonLocator = By.className("avatar-button");

    By accountHeadingLocator = By.className("account-heading");

    By membershipHeadingLocator = By.className("membership-heading");

    By membershipUsernameLocator = By.className("membership-username");

    By membershipPasswordLocator = By.className("membership-password");

    By planParagraphLocator = By.className("plan-paragraph");

    By planDetailsLocator = By.className("plan-details");

    By logoutButtonLocator = By.className("logout-button");


    public void clickOnAvatarButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnAvatarButtonLocator));
        driver.findElement(clickOnAvatarButtonLocator).click();
    }

    public String getTheAccountHeading(){
        return driver.findElement(accountHeadingLocator).getText();
    }

    public String getTheMembershipHeading(int index){
        return driver.findElements(membershipHeadingLocator).get(index).getText();
    }

    public String getTheMembershipUsername(){
        return driver.findElement(membershipUsernameLocator).getText();
    }

    public String getTheMembershipPassword(){
        return driver.findElement(membershipPasswordLocator).getText();
    }

    public String getThePlanParagraph(){
        return driver.findElement(planParagraphLocator).getText();
    }

    public String getThePlanDetails(){
        return driver.findElement(planDetailsLocator).getText();
    }

    public WebElement checkTheLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));
        return driver.findElement(logoutButtonLocator);
    }



}
