package stepDefinitions;
import java.time.Duration;


import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class Steps {
    WebDriver driver = null;

    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Given("Open the url of the application \\(url: {string})")
    public void openTheApplication(String url) {
        driver.get(url);
    }

    @When("Click on the Log in option")
    public void clickLoginOption() {
        driver.findElement(By.cssSelector("#login2")).click();
    }

    @And("Enter username and password \\(username: {string} , password: {string})")
    public void enterLoginCredentials(String userName, String pwd) {
        driver.findElement(By.cssSelector("#loginusername")).sendKeys(userName);
        driver.findElement(By.cssSelector("#loginpassword")).sendKeys(pwd);
    }

    @And("Click on the Log in button")
    public void clickLoginButton() {
        WebElement ele=  driver.findElement(By.cssSelector("button[onclick='logIn()']"));
        ele.click();
    }

    @Then("Validate the welcome user message")
    public void validateWelcomeMessage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser")));
        String welcomeMsg = ele.getText();
        Assert.assertEquals(welcomeMsg, "Welcome manishkumar1990");

//		if(welcomeMsg.equals("Welcome manishkumar1990"))
//			System.out.println("Validation step passed");
//		else
//			throw new InterruptedException("Validation failed");
        driver.quit();
    }
    

}
