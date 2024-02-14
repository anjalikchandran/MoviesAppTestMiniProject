package stepdefinitions;

import Pages.AccountPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountPageTest {
    WebDriver driver = Hooks.getDriver();
    AccountPage accountPage;
    HomePage homePage;
    WebDriverWait wait;
    @And("I click on avatar button")
    public void clickOnAvatarButton() {
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);

        //Click on the account Page button
        homePage.getAvatarButton().click();
        //Wait until exp conditions become url
        String expectedAvatarUrl = "https://qamoviesapp.ccbp.tech/account";
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedAvatarUrl));

        //check whether expectedAvatarUrl macthes with currentUrl
        Assert.assertEquals(driver.getCurrentUrl(), expectedAvatarUrl, "URL's doesnt match");
        System.out.println(driver.getCurrentUrl());

        //get account heading
        String expectedHeading = "Account";
        String actualHead = accountPage.getAccountHeadText();
        Assert.assertEquals(expectedHeading, actualHead, "Account page head Text doesn't match");
        System.out.println(actualHead);

        //getMemberShipHeading
        String memberShipHeading = "Member ship";
        String actualMemberShipHead = accountPage.getMembershipHead();
        Assert.assertEquals(actualMemberShipHead, memberShipHeading, "MemberShip Heading doesnt match");
        System.out.println(actualMemberShipHead);

        //get username
        String expectedUsernameText = "User name : rahul";
        String actualexpUsernameText = accountPage.getUsername();
        Assert.assertEquals(actualexpUsernameText, expectedUsernameText, "username doesnt match");
        System.out.println(actualexpUsernameText);

        //get password
        String exp = "Password : **********";
        Assert.assertEquals(accountPage.getPasword(), exp, "Password doesnt match");
        System.out.println(accountPage.getPasword());

        //planDeatails
        Assert.assertTrue(accountPage.getPlanDetails(), "plan deatails not visible");
        if (accountPage.getPlanDetails() == true) {
            System.out.println("Plan details are displayed");
        } else {
            System.out.println("Plan details are not displayed");
        }

        //Avaialble plans
        String[] planArray = {"Premium", "Ultra HD"};
        for (int i = 0; i < 2; i++) {
            String actualPlans = accountPage.getPlans(i);
            Assert.assertEquals(planArray[i], actualPlans);
            System.out.println("Available plans are: " + actualPlans);
        }
        //check logout button is displayed
        Assert.assertTrue(accountPage.logOutBtnIsDisplayed(),"logout button is not visible");
        if(accountPage.logOutBtnIsDisplayed()==true){
            System.out.println("logout button is visible");
        }
    }
    @And("logout the app")
    public void ClickLogOut(){
       //click on the logout button
       accountPage.logoutClick();
    }
    @Then("I should be redirected to the login page")
    public void NavigateloginPage(){
        //check logout successfully completed or not
        String expectedLoginUrl="https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expectedLoginUrl));
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedLoginUrl,currentUrl,"logout failed");
        if(expectedLoginUrl.equals(currentUrl)){
            System.out.println("Successfully loggedout");
        }
        System.out.println(currentUrl);
    }

}
