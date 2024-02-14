package stepdefinitions;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderSectionTest {
    HomePage homePage;
    WebDriver driver = Hooks.getDriver();
    @And("Check HomePage header section UI")
    public void headerSectionUI() {
        homePage = new HomePage(driver);

        //Test whether the Website logo is displayed
        Assert.assertTrue(homePage.GetWebsiteLogo(), "WebsiteLogo is not displayed");
        System.out.println(homePage.GetWebsiteLogo());
        Assert.assertEquals(homePage.GetWebsiteLogo(), true, "WebsiteLogo is not displayed ,failed ");

        //Test the Navbar elements
        String navElement[] = {"Home", "Popular"};
        for (int i = 0; i < 2; i++) {
            System.out.println(homePage.getnavBarLinks(i));
            Assert.assertEquals(homePage.getnavBarLinks(i), navElement[i], "NavBarElemnets Not matching");
        }
        //check search button is displayed or not
        Assert.assertTrue(homePage.searchButtonIsDisplayed(), "search button is failed to display");
        System.out.println(homePage.searchButtonIsDisplayed());
        Assert.assertEquals(homePage.searchButtonIsDisplayed(), true, "search button is not displayed");
        if (homePage.searchButtonIsDisplayed() == true) {
            System.out.println("search button nav element is displayed");
        } else {
            System.out.println("search button nav element is not displayed");
        }
        //check avatar button in the nav element is diplayed or not
        Assert.assertTrue(homePage.avatarButtonIsDisplayed(), "search button is failed to display");
        System.out.println(homePage.avatarButtonIsDisplayed());
        Assert.assertEquals(homePage.avatarButtonIsDisplayed(), true, "search button is not displayed");
        if (homePage.avatarButtonIsDisplayed() == true) {
            System.out.println("avatar button nav element is displayed");
        } else {
            System.out.println("avatar button nav element is not displayed");
        }
        System.out.println();
    }
        @Then("Test the Header Section Functionalities")
        public void testHeaderSectionFunctionality(){

          //Test the navigation to Home and Popular pages through elements in header section
            String []expectedUrl={"https://qamoviesapp.ccbp.tech/","https://qamoviesapp.ccbp.tech/popular"};
            for (int i=0;i<2;i++) {
                homePage.getnavBarLinksclick(i);
                String currentUrl = driver.getCurrentUrl();
                System.out.println(currentUrl);
                Assert.assertEquals(currentUrl, expectedUrl[i], "navigation to Home and Popular pages is not through elements in header section");
            if(currentUrl.equals(expectedUrl[i])){
                 System.out.println("navigation to Home and Popular pages is through elements in header section");
             }
         }
            //Test the navigation to account page through elements in header section
            homePage.getAvatarButton().click();
            String accountrUrl="https://qamoviesapp.ccbp.tech/account";
            System.out.println(driver.getCurrentUrl());
            Assert.assertEquals(accountrUrl,driver.getCurrentUrl()," navigation to account page is not through elements in header section");
    }
}

