package stepdefinitions;

import Pages.HomePage;
import Pages.PopularPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MovieDetailsPageTest {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage;


    @And("Test In the Home Page click on any Movie and test all the UI elements present in it")
    public void TesHometMovieDetailsPage() {
        homePage = new HomePage(driver);

        //In the Home Page click on any Movie and test all the UI elements present in it

        //click on any movie
        homePage.GetclickAMovie(0);

        //backgroundImage
        Assert.assertTrue(homePage.getBackgroundImage().isDisplayed(), "Background image not visible");
        //get the movie title
        String actualMovieTitle = homePage.getMovieTitle();
        String expectedMovieTitle = "No Time to Die";
        Assert.assertEquals(actualMovieTitle, expectedMovieTitle, "movie title is not matching");
        System.out.println(actualMovieTitle);

        //get the movie time , sensor and year of release
        String[] detailsArray = {"2h 43m", "U/A", "2021"};
        for (int i = 0; i < detailsArray.length; i++) {
            Assert.assertEquals(detailsArray[i], homePage.getMovieDetailsText(i), " movies Details not matching");
            System.out.println(homePage.getMovieDetailsText(i));
        }

        //get movie overview
        String expectedMovieReview = "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.";
        Assert.assertEquals(homePage.getmovieOverview(), expectedMovieReview, "Movie review doesn't match");
        System.out.println(homePage.getmovieOverview());

        //playButton is visibled
        Assert.assertTrue(homePage.getmoviewPlayButton());
        if (homePage.getmoviewPlayButton() == true) {
            System.out.println("Play button is displayed");
        } else {
            System.out.println("Play button is not displayed");
        }

        //check all Movie deatails Heading
        String headingArray[] = {"Genres", "Audio Available", "Rating Count", "Rating Average", "Budget", "Release Date"};
        for (int i = 0; i < headingArray.length; i++) {
            String actualHeading = homePage.GetmovieDetailsPageHeading(i);
            Assert.assertEquals(headingArray[i], actualHeading);
            System.out.println("No time to die movie headings are: "+actualHeading);
        }
        //check all CategoryParagraph
        String CategoryParagraph[] = {"Adventure", "Action", "Thriller", "Spanish", "French", "English", "Italian", "Russian", "1396", "7.5", "24.2 Crores", "29th September 2021"};
        for (int i = 0; i < 12; i++) {
            Assert.assertEquals(homePage.getCategoryParagraph(i), CategoryParagraph[i], "category pargraph doesnt match");
            System.out.println(homePage.getCategoryParagraph(i) + " : " + CategoryParagraph[i]);
        }

        //Get More Movies Heading
        String expected = "More like this";
        Assert.assertEquals(homePage.getMoreMoviesHeadText(), expected, "More Movies Like This heading doesnt match");
        System.out.println(homePage.getMoreMoviesHeadText());
        //Get more Movies List Size and compare
        int expectedSize = 38;
        Assert.assertEquals(homePage.getMoreMoviesList(), expectedSize, "Size doesnt match");
        System.out.println("More Movies List Size is: " + homePage.getMoreMoviesList());
    }
    @And("click on popular page and any movie and test ui")
    public void TesPopulartMovieDetailsPage() {
        //click on Popular
        homePage.getnavBarLinksclick(1);
        //click on any movie
        homePage.GetclickAMovie(4);

        //check backgroundImage-Spiderman is displayed or not
        Assert.assertTrue(homePage.spiderManBackGroundImg().isDisplayed(),"Spiderman background image is not displayed");
        if(homePage.spiderManBackGroundImg().isDisplayed()==true){
            System.out.println("Spiderman background image is displayed");
        }
        else{
            System.out.println("Spiderman background image is not displayed");
        }
        //check movie-title
        Assert.assertEquals(homePage.spidermanHeadText(),"The Amazing Spider-Man","Movie title doesnt match");
        System.out.println(homePage.spidermanHeadText());

        //Check movie-deatils
        String []detailsArray2={"2h 43m","U/A","2021"};
        for(int i=0;i<detailsArray2.length;i++){
            System.out.println(homePage.getMovieDetailsText(i));
            Assert.assertEquals(detailsArray2[i],homePage.getMovieDetailsText(i)," movies Details not matching");
        }

        //get movie overview
        String expectedMovieReview="Peter Parker is an outcast high schooler abandoned by his parents as a boy, leaving him to be raised by his Uncle Ben and Aunt May.";
        Assert.assertEquals(homePage.getmovieOverview(),expectedMovieReview,"Movie review doesn't match");
        System.out.println(homePage.getmovieOverview());
        //playButton
        Assert.assertTrue( homePage.getmoviewPlayButton(),"Spiderman movie play button is not displayed");
        if (homePage.getmoviewPlayButton() == true) {
            System.out.println("Play button is displayed");
        } else {
            System.out.println("Play button is not displayed");
        }
        //check all Movie deatails Heading
        String headingArray2[] = {"Genres", "Audio Available", "Rating Count", "Rating Average", "Budget", "Release Date"};
        for (int i = 0; i < headingArray2.length; i++) {
            String actualHeading = homePage.GetmovieDetailsPageHeading(i);
            Assert.assertEquals(headingArray2[i], actualHeading);
            System.out.println("spiderman movie headings are: "+actualHeading);
        }
        //Get all spiderman movie CategoryParagraph
        String[]CategoryParagraph2={"Adventure","Action","Thriller","English","French","Italian","Russian","Spanish","1672","7.6","13 Crores","29th September 2021"};
        for(int i=0;i<12;i++) {
            Assert.assertEquals(homePage.getCategoryParagraph(i),CategoryParagraph2[i],"category pargraph doesnt match");
            System.out.println("Spiderman Category paragrah items: "+homePage.getCategoryParagraph(i)+" - "+CategoryParagraph2[i]);
        }

        //Get More Movies Heading
        String expected="More like this";
        Assert.assertEquals(homePage.getMoreMoviesHeadText(),expected,"More Movies Like This heading doesnt match");
        System.out.println(homePage.getMoreMoviesHeadText());

        //Get more Movies List Size and compare
        int expectedSize=38;
        Assert.assertEquals(homePage.getMoreMoviesList(),expectedSize,"Size doesnt match");
        System.out.println("More Movies List Size is: "+ homePage.getMoreMoviesList());

    }







}
