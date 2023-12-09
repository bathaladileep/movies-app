package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MovieDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    public MovieDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By clickOnHomePageMovieLocator = By.xpath("//img[@src = 'https://assets.ccbp.in/frontend/react-js/movies-app/shang-chi-and-the-legend-of-the-ten-rings-movie-poster.png']");

    By movieTitleLocator = By.className("movie-title");

    By movieWatchTimeLocator = By.className("watch-time");

    By movieSensorRatingLocator = By.className("sensor-rating");

    By movieReleaseYearLocator = By.className("release-year");

    By movieOverviewLocator = By.className("movie-overview");

    By moviePlayButtonLocator = By.className("play-button");

    By navToPopularLinkLocator = By.linkText("Popular");

    By clickOnPopularPageMovieLocator = By.xpath("//img[@src = 'https://assets.ccbp.in/frontend/react-js/movies-app/the-amazing-spider-man-movie-poster.png']");



    public void clickOnTheHomeMovieDetailsPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnHomePageMovieLocator));
        driver.findElement(clickOnHomePageMovieLocator).click();
    }

    public String getTheMovieTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitleLocator));
        return driver.findElement(movieTitleLocator).getText();
    }

    public String getTheWatchTime(){
        return driver.findElement(movieWatchTimeLocator).getText();
    }

    public String getTheSensorRating(){
        return driver.findElement(movieSensorRatingLocator).getText();
    }

    public String getTheReleaseYear(){
        return driver.findElement(movieReleaseYearLocator).getText();
    }

    public String getTheOverview(){
        return driver.findElement(movieOverviewLocator).getText();
    }

    public WebElement checkThePlayButton(){
        return driver.findElement(moviePlayButtonLocator);
    }

    public void clickOnPopularLinkPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navToPopularLinkLocator));
        driver.findElement(navToPopularLinkLocator).click();
    }

    public void clickOnThePopularMovieDetailsPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnPopularPageMovieLocator));
        driver.findElement(clickOnPopularPageMovieLocator).click();
    }





}
