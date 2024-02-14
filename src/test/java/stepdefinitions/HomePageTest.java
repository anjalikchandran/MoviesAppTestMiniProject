package stepdefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
    HomePage homePage;
    WebDriver driver = Hooks.getDriver();

    @Then("Check HomePage User Interface")
    public void onHomePage() {
        homePage = new HomePage(driver);

        //Test whether the play button is displayed or not
        Assert.assertTrue(homePage.isPlayButtonVisible(),"play button is not visble");
        if(homePage.isPlayButtonVisible()==true){
            System.out.println("play button is visble");
        }


        //Test the heading texts of each section
        String [] expectedHeading={"Trending Now","Originals"};
        for(int i=0;i<2;i++){
            Assert.assertEquals(homePage.gethomeHeading(i),expectedHeading[i],"Heading Mismatched");
            System.out.println("HomePage heading texts of each section is displayed");
            break;
        }

        //Test whether the Movies are displayed, in the corresponding movies sections
        int expectedTrendingMovieCount=10;
        for(int i=0;i<10;i++) {
            Assert.assertEquals(homePage.GettrendingNowMovies(), expectedTrendingMovieCount, "Trending Now movie Section count is not matching");
            int actualCount = homePage.GettrendingNowMovies();
            if (actualCount == 10) {
                System.out.println(actualCount);
                break;
            }
        }
         Assert.assertTrue(homePage.trendingMoviesIsDisplayed(),"Trending Now movie Section is not displayed");
            if(homePage.trendingMoviesIsDisplayed()==true){
                System.out.println("Movies displayed in the trending movies section");
            }

        int expectedOriginalsCount=10;
        for(int i=0;i<10;i++){
            Assert.assertEquals(homePage.GetoriginalsMovies(),expectedOriginalsCount,"Trending Now movie Section is not displayed");
            int actualCount=homePage.GetoriginalsMovies();
            if(actualCount==10) {
                System.out.println(actualCount);
                break;
            }
        }
        Assert.assertTrue(homePage.originalMoviesIsDisplayed(),"originals movie Section is not displayed");
        if(homePage.originalMoviesIsDisplayed()==true){
            System.out.println("Movies displayed in the originals section");
        }

        //Test the Contact Us Section
        for(int i=0;i<4;i++) {
            //checking 4 footer section element is diplayed or not
            Assert.assertTrue(homePage.getfooterSectionicon(i).isDisplayed(), "Footer Section is not displayed");
            System.out.println("Home Page footerSectionicon is displayed");
            break;
        }
        if(homePage.footerSectionCount()==4){
            System.out.println("Home Page footer section icon count is 4");
        }
        //checking contact us section text is matching or not
        Assert.assertEquals(homePage.getContactUsText(),"Contact Us");
        System.out.println(homePage.getContactUsText());

        //checking slick-slider arrow is visible or not
        Assert.assertTrue(homePage.GetSlickSliderIsDisplayed());
        if(homePage.GetSlickSliderIsDisplayed()==true) {
            System.out.println("slick-slider arrow is visible "+homePage.GetSlickSliderIsDisplayed());
        }

    }

}








