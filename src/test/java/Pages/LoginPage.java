package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
     WebDriverWait wait;

    By logoImgLocator=By.className("login-website-logo");
    By headingTextLocator=By.className("sign-in-heading");
    By inputlabelsLocator=By.className("input-label");
    By loginButtonLocaor=By.className("login-button");
    By usernameInputLocator=By.id("usernameInput");
    By passwordInputLocator=By.id("passwordInput");
    By errorMessageLocator=By.className("error-message");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean getlogoImg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoImgLocator));
        return driver.findElement(logoImgLocator).isDisplayed();
    }
    public String getheadingText(){
        return driver.findElement(headingTextLocator).getText();
    }
    public String getinputlabels(int index){
        return driver.findElements(inputlabelsLocator).get(index).getText();
    }
    public String getLoginButtonText(){
        return  driver.findElement(loginButtonLocaor).getText();
    }
    public void clickLoginButton(){
        driver.findElement(loginButtonLocaor).click();
    }
    public String getErrorText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return driver.findElement(errorMessageLocator).getText();
    }
    public void enterUsername(String name){
        driver.findElement(usernameInputLocator).sendKeys(name);
    }
    public void enterPassword(String pin){
        driver.findElement(passwordInputLocator).sendKeys(pin);

    }
    public void loginToApplication(String userId,String pin){
        enterUsername(userId);
        enterPassword(pin);
        clickLoginButton();
    }
}
