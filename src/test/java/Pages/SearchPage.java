package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    By searchButtonLocator=By.cssSelector("button.search-empty-button");
    By searchBoxLocator=By.id("search");
    By searchClickLocator=By.className("search-button");
    By clickOnMovie=By.cssSelector("a.link-item");
    By movieTitle=By.className("movie-title");



    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getsearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        driver.findElement(searchButtonLocator).click();
    }
    public void getsearchBox(String movieName){
        driver.findElement(searchBoxLocator).sendKeys(movieName);
    }
    public void getsearchClick(){
        wait.until(ExpectedConditions.elementToBeClickable(searchClickLocator));
        driver.findElement(searchClickLocator).click();
    }
    public void searchAndClick(String movieName){
        getsearchBox(movieName);
        getsearchClick();
    }
    public void GetClickOnMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnMovie));
        driver.findElement(clickOnMovie).click();
    }
    public String GetmovieNameList(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        return driver.findElements(movieTitle).get(index).getText();
    }
}
