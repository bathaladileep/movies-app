package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;

public class PopularPage {

    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By popularPageLinkLocator = By.linkText("Popular");

    By moviesListLocator = By.className("movie-icon-item");

    public void navigateToThePopularLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularPageLinkLocator));
        driver.findElement(popularPageLinkLocator).click();
    }

    public List<WebElement> listOfTheMoviesDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesListLocator));
        return driver.findElements(moviesListLocator);
    }

}
