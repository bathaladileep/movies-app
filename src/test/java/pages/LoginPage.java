package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By loginWebsiteLogoLocator = By.className("login-website-logo");

    By loginHeadingTextLocator = By.className("sign-in-heading");

    By loginLabelTextLocator = By.className("input-label");

    By loginButtonLocator = By.className("login-button");

    By usernameFiledLocator = By.id("usernameInput");

    By passwordFiledLocator = By.id("passwordInput");

    By errorMessageLocator = By.className("error-message");

    public WebElement findWebsiteLogoImage(){
        return driver.findElement(loginWebsiteLogoLocator);
    }

    public String getTheLoginHeadingText(){
        return driver.findElement(loginHeadingTextLocator).getText();
    }

    public String getTheLabelText(int index){
        return driver.findElements(loginLabelTextLocator).get(index).getText();
    }

    public WebElement findTheLoginButton(){
        return driver.findElement(loginButtonLocator);
    }

    public void enterTheUsername(String name){
        driver.findElement(usernameFiledLocator).sendKeys(name);
    }

    public void enterThePassword(String password){
        driver.findElement(passwordFiledLocator).sendKeys(password);
    }

    public void clickTheLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }

    public void loginToApplication(String name, String password){
        enterTheUsername(name);
        enterThePassword(password);
        clickTheLoginButton();
    }

    public String getTheErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return driver.findElement(errorMessageLocator).getText();
    }














}
