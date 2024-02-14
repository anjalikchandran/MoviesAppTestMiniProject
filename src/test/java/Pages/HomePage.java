package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By moviesHeading= By.className("movies-list-heading");
    By playbuttonLocator=By.className("home-movie-play-button");
    By trendingNowMovies=By.xpath("//h1[text()='Trending Now']/following-sibling::div/descendant::img");
    By originalsMovies=By.xpath("//h1 [text()='Originals']/following::div/descendant::img");
    By footerSectionicon=By.cssSelector("svg[class^='icon-']");
    By contactUs =By.className("contact-us-paragraph");
    By slickSlider=By.cssSelector("div.App button");

    //HeaderSectionTest
    By websitelogoLocator=By.className("website-logo");
    By navBarLinksLocator=By.className("nav-link");
    By searchButtonLocator=By.className("search-empty-button");
    By avatarButton=By.className("avatar-button");

    //MovieDetailsPage
    By clickAMovie=By.cssSelector("a.link-item");
    By movieTitle=By.className("movie-title");
    By backgroundImage=By.cssSelector("div[style*='/movies-app/no-time-to-die-movie-']");
    By movieDetails=By.cssSelector("div.movie-review-container>p");
    By movieOverview=By.className("movie-overview");
    By moviewPlayButton=By.className("play-button");
    By movieDetailsPageHeading=By.cssSelector("div.detailed-movie-categories-container h1");
    By categoryParagraph=By.className("category-paragraph");
    By moreMoviesHeading=By.className("similar-movies-heading");
    By moreMoviesList=By.cssSelector("ul.similar-movies-list-container>li");
    By spiderManBackGroundImg=By.cssSelector("div[style*='movies-app/the-amazing-spider-man-movie-background']");
    By spidermanTitle=By.className("movie-title");




  //HomepageTest methods
    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public String gethomeHeading(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesHeading));
        return driver.findElements(moviesHeading).get(index).getText();
    }
    public boolean isPlayButtonVisible(){
         wait.until(ExpectedConditions.visibilityOfElementLocated(playbuttonLocator));
         return driver.findElement(playbuttonLocator).isDisplayed();
    }
    public int GettrendingNowMovies(){
        return driver.findElements(trendingNowMovies).size();
    }
    public boolean trendingMoviesIsDisplayed(){
        return driver.findElement(trendingNowMovies).isDisplayed();
    }

    public int GetoriginalsMovies(){
        return driver.findElements(originalsMovies).size();
    }
    public boolean originalMoviesIsDisplayed(){
        return driver.findElement(originalsMovies).isDisplayed();
    }
    public WebElement getfooterSectionicon(int index){
          return driver.findElements(footerSectionicon).get(index);
    }
    public int footerSectionCount(){
        return driver.findElements(footerSectionicon).size();
    }
    public String getContactUsText(){
        return driver.findElement(contactUs).getText();
    }
    public boolean GetSlickSliderIsDisplayed(){
        return driver.findElement(slickSlider).isDisplayed();
    }

    //HeaderSectionMethods
    public boolean GetWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(websitelogoLocator));
        return  driver.findElement(websitelogoLocator).isDisplayed();
    }
    public String getnavBarLinks(int index){
        return driver.findElements(navBarLinksLocator).get(index).getText();
    }
    public boolean searchButtonIsDisplayed(){
        return driver.findElement(searchButtonLocator).isDisplayed();
    }
    public boolean avatarButtonIsDisplayed(){
        return driver.findElement(avatarButton).isDisplayed();
    }
    public void getnavBarLinksclick(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navBarLinksLocator));
        driver.findElements(navBarLinksLocator).get(index).click();
    }
    public WebElement getAvatarButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarButton));
        return driver.findElement(avatarButton);
    }
    public void GetclickAMovie(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickAMovie));
        driver.findElements(clickAMovie).get(index).click();
    }

    //MoviesDetailsPage method
    public String getMovieTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        return driver.findElement(movieTitle).getText();
    }
    public WebElement getBackgroundImage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(backgroundImage));
        return driver.findElement(backgroundImage);
    }
    public String getMovieDetailsText(int index){
        return driver.findElements(movieDetails).get(index).getText();
    }
    public String getmovieOverview(){
        return driver.findElement(movieOverview).getText();
    }
    public boolean getmoviewPlayButton() {
        wait.until(ExpectedConditions.elementToBeClickable(moviewPlayButton));
        return driver.findElement(moviewPlayButton).isDisplayed();
    }
    public String GetmovieDetailsPageHeading(int index){
        return driver.findElements(movieDetailsPageHeading).get(index).getText();
    }
    public String getCategoryParagraph(int index){
        return driver.findElements(categoryParagraph).get(index).getText();
    }
    public String getMoreMoviesHeadText(){
        return driver.findElement(moreMoviesHeading).getText();
    }
    public int getMoreMoviesList(){
        return driver.findElements(moreMoviesList).size();
    }
    public WebElement spiderManBackGroundImg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(spiderManBackGroundImg));
        return  driver.findElement(spiderManBackGroundImg);
    }
    public String spidermanHeadText(){
        return driver.findElement(spidermanTitle).getText();
    }

}
