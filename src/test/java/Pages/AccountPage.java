package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;

    By accountHead = By.className("account-heading");
    By membershipHead = By.className("membership-heading");
    By username = By.className("membership-username");
    By password = By.className("membership-password");
    By planDetails = By.cssSelector("div.plan-container>p");
    By plans = By.cssSelector("div.plan-details-container>p");
    By logout = By.className("logout-button");


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getAccountHeadText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountHead));
        return driver.findElement(accountHead).getText();
    }

    public String getMembershipHead() {
        return driver.findElement(membershipHead).getText();
    }

    public String getUsername() {
        return driver.findElement(username).getText();
    }

    public String getPasword() {
        return driver.findElement(password).getText();
    }

    public boolean getPlanDetails() {
        return driver.findElement(planDetails).isDisplayed();
    }

    public String getPlans(int index) {
        return driver.findElements(plans).get(index).getText();
    }
    public boolean logOutBtnIsDisplayed(){
        return driver.findElement(logout).isDisplayed();
    }

    public void logoutClick() {
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        driver.findElement(logout).click();
    }
}
