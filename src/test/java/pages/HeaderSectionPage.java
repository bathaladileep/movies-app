package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HeaderSectionPage {

    WebDriver driver;
    WebDriverWait wait;

    public HeaderSectionPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By headerPageWebsiteLogoLocator = By.className("website-logo");

    By navHomeSectionLocator = By.linkText("Home");

    By navPopularPageLocator = By.linkText("Popular");

    By navSearchFieldLocator = By.className("search-empty-button");

    By navAccountAvatarButtonLocator = By.className("avatar-button");


    public WebElement findTheHeaderWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerPageWebsiteLogoLocator));
        return driver.findElement(headerPageWebsiteLogoLocator);
    }

    public WebElement findTheHomeLink(){
        return driver.findElement(navHomeSectionLocator);
    }

    public WebElement findThePopularLink(){
        return driver.findElement(navPopularPageLocator);
    }

    public WebElement findTheSearchField(){
        return driver.findElement(navSearchFieldLocator);
    }

    public WebElement findTheAccountAvatarButton(){
        return driver.findElement(navAccountAvatarButtonLocator);
    }

    public void clickTheHomeLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navHomeSectionLocator));
        driver.findElement(navHomeSectionLocator).click();
    }

    public void clickThePopularLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navPopularPageLocator));
        driver.findElement(navPopularPageLocator).click();
    }

    public void clickAccountSection(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navAccountAvatarButtonLocator));
        driver.findElement(navAccountAvatarButtonLocator).click();
    }







}
