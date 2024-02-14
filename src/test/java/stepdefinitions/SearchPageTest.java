package stepdefinitions;

import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchPageTest {
    WebDriver driver = Hooks.getDriver();
    SearchPage searchPage;
    HomePage homePage;

    @And("I click on the search icon")
    public void clickOnSearchIcon() {
        searchPage=new SearchPage(driver);
        homePage=new HomePage(driver);

        //click on search icon
        searchPage.getsearchButton();
    }
    @And("I should be able navigate to search page")
    public void checkSearchPageUrl(){
        String expectedSearchUrl="https://qamoviesapp.ccbp.tech/search";

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedSearchUrl));

        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl+" "+expectedSearchUrl);
        Assert.assertEquals(actualUrl,expectedSearchUrl,"not navigated to search page");

        System.out.println();
    }

    @Then("Test the Search functionality by searching with some movie names and the count of movies displayed")
    public void searchSomeMovies(){
        String[] namesMovie = {"Avatar", "Titanic","No Time to Die","Squid Game","Death Proof","Shang-Chi and the Legend of the Ten Rings"}; //"Shang-Chi and the Legend of the Ten Rings","Death Proof"
        int count=0;
        for (int i=0;i<namesMovie.length;i++) {
          searchPage.searchAndClick(namesMovie[i]);

         //click on movie to redirect to the movie details page
          searchPage.GetClickOnMovie();

         //click on movie to redirect to the movie details page
          Assert.assertEquals(searchPage.GetmovieNameList(0),namesMovie[i]);
          if(searchPage.GetmovieNameList(0).equals(namesMovie[i])){
              System.out.println("Search functionality by searching with some movie names success: "+searchPage.GetmovieNameList(0));

          }
          //locate search box locator
          searchPage.getsearchButton();

          //count of movies displayed
            count++;
        }
        //check-count of movies displayed is equals to the length of namesMovie array
        Assert.assertEquals(count,namesMovie.length,"count of movies displayed doesnt match with length of namesMovie array");
        System.out.println("Count of movie displayed "+count);
        if (count == namesMovie.length) {
            System.out.println("All the movies are displayed");
        } else {
            System.out.println("Few movies missing...");
        }


    }
}
