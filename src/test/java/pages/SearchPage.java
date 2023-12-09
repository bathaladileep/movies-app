package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchEmptyButtonLocator = By.className("search-empty-button");

    By searchFiledLocator = By.id("search");

    By searchButtonLocator = By.className("search-button");

    By moviesListLocator = By.className("movie-icon-item");

    public void clickTheSearchEmptyButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmptyButtonLocator));
        driver.findElement(searchEmptyButtonLocator).click();
    }

    public void enterMovieName(String movie){
        driver.findElement(searchFiledLocator).sendKeys(movie);
    }

    public void clickTheSearchButton(){
        driver.findElement(searchButtonLocator).click();
    }

    public List<WebElement> getTheMoviesCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesListLocator));
        return driver.findElements(moviesListLocator);
    }


}
