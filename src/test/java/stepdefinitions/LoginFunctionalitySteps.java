package stepdefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginFunctionalitySteps {

   WebDriver driver = Hooks.getDriver();
    LoginPage loginPage;
     @Given("I am on the loginPage")
    public void NaviagteToApp(){
         driver.get("https://qamoviesapp.ccbp.tech");
         loginPage=new LoginPage(driver);
     }
     @When("Test the User Interface")
    public void TesttheUlLoginpage(){

         //Test whether the Website logo image is displayed,
         Assert.assertTrue(loginPage.getlogoImg(),"Website logo is not displayed");

         //Test whether the Heading text is "Login"
         String expectedText = "Login";
         Assert.assertEquals(loginPage.getheadingText(), expectedText, "Heading Text Mismatched");

         //Test whether the label text is "USERNAME","PASSWORD"
         String expectedLAbelText[]={"USERNAME","PASSWORD"};
         for(int i=0;i<2;i++){
             Assert.assertEquals(loginPage.getinputlabels(i),expectedLAbelText[i],"inputLabels Mismatched");
         }
         //Test the "Login" button
         Assert.assertEquals(loginPage.getLoginButtonText(), "Login", "LoginButton Text Mismatched");
     }
     @And("click On LoginButton")
    public void clickonbutton(){
         //click on loginButton with empty input field
         loginPage.clickLoginButton();
     }
     @Then("Error text will be *Username or password is invalid")
    public void ErrorMessageEmptyInputField(){
         Assert.assertEquals(loginPage.getErrorText(), "*Username or password is invalid", "error Text Mismatched");
         System.out.println(loginPage.getErrorText());
     }
     @When("I Enter a valid Pin")
    public void EmptyUserInputField(){
         //Test the login functionality with empty USERNAME,
         loginPage.loginToApplication("", "rahul@2021");
     }
     @Then("Result text will be Invalid User ID")
    public void ErrorMessageEmptyUserInputField(){
         Assert.assertEquals(loginPage.getErrorText(), "*Username or password is invalid", "EmptyUserId error Text Mismatched");
         System.out.println(loginPage.getErrorText());
     }
     @When("I Enter a valid username")
    public void EmptyPasswordInputField() {
         //Test the login functionality with empty Password,
         loginPage.loginToApplication("rahul", "");
     }
     @And("I Enter invalid password")
    public void inavlidPassword(){
         //Test the login functionality with an incorrect password
         loginPage.loginToApplication("rahul","rahu@kjjj");
     }

     @Then("Error text will be username and password didn't match")
    public void invalidPasswordErrorMessage(){
         Assert.assertEquals(loginPage.getErrorText(),"*username and password didn't match","username and password didn't match failed");
         System.out.println(loginPage.getErrorText());
     }
     @And("I Enter invalid Username")
    public void invalidUsername(){
         //Test the login functionality with an incorrect username
         loginPage.loginToApplication("rahu","rahul@2021");
     }
    @Then("Error text will be *invalid username")
    public void invalidUsernameErrorMessage(){
        Assert.assertEquals(loginPage.getErrorText(),"*invalid username","username and password didn't match failed");
        System.out.println(loginPage.getErrorText());
     }
     @When("I Enter a valid Pin and username")
     public void validuUserNameAndPassword(){
         loginPage.loginToApplication("rahul","rahul@2021");
     }
     @Then("I should be loggedin")
    public void ToHomePage(){
         String ExpectedHomeUrl="https://qamoviesapp.ccbp.tech/";
         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlToBe(ExpectedHomeUrl));

         Assert.assertEquals(driver.getCurrentUrl(),ExpectedHomeUrl,"Failed to navigate home page");
         System.out.println(driver.getCurrentUrl());
     }
}