package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;

    By popularPageMoviesLocator= By.className("link-item");
    By clickOnePopularMovie=By.cssSelector("li.movie-icon-item>a");
    By nameOfTheMovie=By.className("movie-title");

    public PopularPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getpopularPageMovies(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularPageMoviesLocator));
        return driver.findElements(popularPageMoviesLocator).get(index);
    }
    public int getpopularPageMoviesSize(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularPageMoviesLocator));
        return driver.findElements(popularPageMoviesLocator).size();
    }
    public WebElement GetclickOnePopularMovie(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnePopularMovie));
        return driver.findElements(clickOnePopularMovie).get(index);
    }
    public String GetnameOfTheMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfTheMovie));
        return driver.findElement(nameOfTheMovie).getText();
    }
}
