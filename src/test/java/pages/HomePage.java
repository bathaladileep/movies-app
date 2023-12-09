package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By sectionsHeadingTextsLocator = By.className("movies-list-heading");

    By playButtonLocator = By.className("home-movie-play-button");

    By moviesListLocator = By.className("slick-list");

    By contactUsGoggleLocator = By.className("google-icon");

    By contactUsTwitterLocator = By.className("twitter-icon");

    By contactUsInstagramLocator = By.className("instagram-icon");

    By contactUsYoutubeLocator = By.className("youtube-icon");

    By contactUsHeadingText = By.className("contact-us-paragraph");


    public String getTheSectionHeadingText(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionsHeadingTextsLocator));
        return driver.findElements(sectionsHeadingTextsLocator).get(index).getText();
    }

    public WebElement findThePlayButton(){
        return driver.findElement(playButtonLocator);
    }

    public WebElement moviesDisplayedOrNot(){
        return driver.findElement(moviesListLocator);
    }

    public WebElement findContactUsGoggleIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsGoggleLocator));
        return driver.findElement(contactUsGoggleLocator);
    }

    public WebElement findContactUsTwitterIcon(){
        return driver.findElement(contactUsTwitterLocator);
    }

    public WebElement findContactUsInstagramIcon(){
        return driver.findElement(contactUsInstagramLocator);
    }

    public WebElement findContactUsYoutubeIcon(){
        return driver.findElement(contactUsYoutubeLocator);
    }

    public String getTheContactUsText(){
        return driver.findElement(contactUsHeadingText).getText();
    }






}
