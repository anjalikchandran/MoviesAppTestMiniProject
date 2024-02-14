package stepdefinitions;

import Pages.HomePage;
import Pages.PopularPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PopularPageTest {

    WebDriver driver = Hooks.getDriver();
    PopularPage popularPage;
    HomePage homePage;

    @And("I Test the Popular Page UI")
    public void  testPopularPageUI(){
        popularPage=new PopularPage(driver);
        homePage=new HomePage(driver);

        //click on Popular page link
        homePage.getnavBarLinksclick(1);

        String expectedPopularUrl="https://qamoviesapp.ccbp.tech/popular";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedPopularUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedPopularUrl,currentUrl,"popular page Url doesn't match");
        System.out.println(currentUrl);

        for(int i=0;i<30;i++) {
            Assert.assertTrue(popularPage.getpopularPageMovies(i).isDisplayed());
            int actualSize=popularPage.getpopularPageMoviesSize();
            int expectedSize=30;
            Assert.assertEquals(expectedSize,actualSize,"movies are not displayed in the popular page as Expected");
            System.out.println(actualSize);
            if(actualSize==30){
                break;
            }
        }
    }
    @And("click on any popluar movie")
    public void  clickOnPopularMovie(){
        popularPage.GetclickOnePopularMovie(0).click();
    }
    @And("I should be redirected to the movie details page")
    public void naviagateToMoviesPage(){
        String expectedTitle="Venom";
        String actualTitle=popularPage.GetnameOfTheMovie();
        Assert.assertEquals(expectedTitle,actualTitle,"Movie details page movie name doesnt match");
    }
    @Then("back to home page")
    public void backToHomePage(){
        homePage.getnavBarLinksclick(0);
    }





}


