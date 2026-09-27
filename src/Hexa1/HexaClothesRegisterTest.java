package Hexa1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HexaClothesRegisterTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actions = new Actions(driver);

        driver.get("https://hexaclothes.netlify.app/");

        System.out.println("Website opened successfully");
        
        Thread.sleep(3000);
    }


    // Test 1: Click Login button
    @Test(priority = 1)
    public void clickLoginButton() throws InterruptedException {

        By loginButton =
                By.xpath("//button[normalize-space()='Login']");

        WebElement loginButtonElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        System.out.println("Login button is displayed");

        actions.moveToElement(loginButtonElement).perform();

        System.out.println("Mouse pointer moved to Login button");

        Thread.sleep(3000);

        loginButtonElement.click();
        
        System.out.println("Login button clicked successfully");

        Thread.sleep(3000);

        wait.until(ExpectedConditions.urlContains("/login"));

        String currentURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentURL);

        Assert.assertTrue(
                currentURL.contains("/login"),
                "Login page was not opened"
        );

        System.out.println("Login page opened successfully");

        Thread.sleep(3000);
    }
    
 // Test 2: Click Register here
    @Test(priority = 2)
    public void clickRegisterHere() throws InterruptedException {

        // Click Login
        By loginButton =
                By.xpath("//button[normalize-space()='Login']");

        WebElement loginButtonElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        actions.moveToElement(loginButtonElement).perform();

        System.out.println("Mouse pointer moved to Login button");

        Thread.sleep(3000);

        loginButtonElement.click();

        System.out.println("Login button clicked successfully");

        Thread.sleep(3000);
        
     // Wait for Login page
        wait.until(ExpectedConditions.urlContains("/login"));

        System.out.println("Login page opened successfully");

        Thread.sleep(3000);


        // Locate Register here
        By registerHere =
                By.xpath("//a[normalize-space()='Register here']");

        WebElement registerLink =
                wait.until(ExpectedConditions.visibilityOfElementLocated(registerHere));

        System.out.println("Register here link is displayed");

        wait.until(ExpectedConditions.elementToBeClickable(registerHere));

        // Move mouse pointer to Register here
        actions.moveToElement(registerLink).perform();

        System.out.println("Mouse pointer moved to Register here option");

        Thread.sleep(3000);
        
     // Click Register here
        registerLink.click();

        System.out.println("Register here option clicked successfully");

        Thread.sleep(3000);

        // Wait for Register page
        wait.until(ExpectedConditions.urlContains("/register"));

        String currentURL = driver.getCurrentUrl();

        System.out.println("Register page URL: " + currentURL);

        Assert.assertTrue(
                currentURL.contains("/register"),
                "Register page was not opened"
        );

        System.out.println("Register page opened successfully");

        Thread.sleep(3000);
    }
    
 // Test 3: Verify Register page
    @Test(priority = 3)
    public void verifyRegisterPage() throws InterruptedException {

        // Click Login
        By loginButton =
                By.xpath("//button[normalize-space()='Login']");

        WebElement loginButtonElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        actions.moveToElement(loginButtonElement).perform();

        System.out.println("Mouse pointer moved to Login button");

        Thread.sleep(3000);

        loginButtonElement.click();

        System.out.println("Login button clicked successfully");
        
        Thread.sleep(3000);

        // Wait for Login page
        wait.until(ExpectedConditions.urlContains("/login"));

        System.out.println("Login page opened successfully");

        Thread.sleep(3000);


        // Locate Register here
        By registerHere =
                By.xpath("//a[normalize-space()='Register here']");

        WebElement registerLink =
                wait.until(ExpectedConditions.visibilityOfElementLocated(registerHere));

        System.out.println("Register here link is displayed");

        wait.until(ExpectedConditions.elementToBeClickable(registerHere));
        
     // Move mouse pointer
        actions.moveToElement(registerLink).perform();

        System.out.println("Mouse pointer moved to Register here option");

        Thread.sleep(3000);

        // Click Register here
        registerLink.click();

        System.out.println("Register here option clicked successfully");

        Thread.sleep(3000);

        // Wait for Register page
        wait.until(ExpectedConditions.urlContains("/register"));

        String currentURL = driver.getCurrentUrl();

        System.out.println("Register page URL: " + currentURL);
        
        Assert.assertTrue(
                currentURL.contains("/register"),
                "Register page was not opened"
        );

        System.out.println("Register page verified successfully");

        Thread.sleep(3000);
    }


    // Test 4: Enter all registration details and click Register
    @Test(priority = 4)
    public void registerWithValidDetails() throws InterruptedException {

        // =====================================================
        // STEP 1: Click Login button
        // =====================================================

        By loginButton =
                By.xpath("//button[normalize-space()='Login']");

        WebElement loginButtonElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        System.out.println("Login button is displayed");
        
     // Move mouse pointer to Login button
        actions.moveToElement(loginButtonElement).perform();

        System.out.println("Mouse pointer moved to Login button");

        Thread.sleep(3000);

        // Click Login
        loginButtonElement.click();

        System.out.println("Login button clicked successfully");

        Thread.sleep(3000);


        // =====================================================
        // STEP 2: Verify Login page
        // =====================================================
        
        wait.until(ExpectedConditions.urlContains("/login"));

        System.out.println("Login page opened successfully");

        Thread.sleep(3000);


        // =====================================================
        // STEP 3: Click Register here
        // =====================================================

        By registerHere =
                By.xpath("//a[normalize-space()='Register here']");

        WebElement registerLink =
                wait.until(ExpectedConditions.visibilityOfElementLocated(registerHere));

        System.out.println("Register here link is displayed");
        wait.until(ExpectedConditions.elementToBeClickable(registerHere));

        // Move mouse pointer to Register here
        actions.moveToElement(registerLink).perform();

        System.out.println("Mouse pointer moved to Register here option");

        Thread.sleep(3000);

        // Click Register here
        registerLink.click();

        System.out.println("Register here option clicked successfully");

        Thread.sleep(3000);


        // =====================================================
        // STEP 4: Verify Register page
        // =====================================================
        
        wait.until(ExpectedConditions.urlContains("/register"));

        String registerURL = driver.getCurrentUrl();

        System.out.println("Register page URL: " + registerURL);

        Assert.assertTrue(
                registerURL.contains("/register"),
                "Register page was not opened"
        );

        System.out.println("Register page opened successfully");

        Thread.sleep(3000);


        // =====================================================
        // STEP 5: Enter Name
        // =====================================================

        By nameField =
                By.xpath("//input[@id='name']");
        
        WebElement nameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));

        // Move mouse pointer to Name field
        actions.moveToElement(nameElement).perform();

        Thread.sleep(1000);

        // Enter Name
        nameElement.sendKeys("Ashish Muraly");

        System.out.println("Name entered successfully");

        Thread.sleep(3000);
     // =====================================================
        // STEP 6: Enter Email
        // =====================================================

        By emailField =
                By.xpath("//input[@id='email']");

        WebElement emailElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));

        // Move mouse pointer to Email field
        actions.moveToElement(emailElement).perform();

        Thread.sleep(1000);

        // Enter Email
        emailElement.sendKeys("ashishmuraly020@gmail.com");

        System.out.println("Email entered successfully");

        Thread.sleep(3000);
        
     // =====================================================
        // STEP 7: Enter Password
        // =====================================================

        By passwordField =
                By.xpath("//input[@id='password']");

        WebElement passwordElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        // Move mouse pointer to Password field
        actions.moveToElement(passwordElement).perform();

        Thread.sleep(1000);

        // Enter Password
        passwordElement.sendKeys("Ashish123");

        System.out.println("Password entered successfully");

        Thread.sleep(3000);
        
     // =====================================================
        // STEP 8: Enter Confirm Password
        // =====================================================

        By confirmPasswordField =
                By.xpath("//input[@id='confirmPassword']");

        WebElement confirmPasswordElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));

        // Move mouse pointer to Confirm Password field
        actions.moveToElement(confirmPasswordElement).perform();

        Thread.sleep(1000);

        // Enter Confirm Password
        confirmPasswordElement.sendKeys("Ashish123");

        System.out.println("Confirm Password entered successfully");

        Thread.sleep(3000);
        
     // =====================================================
        // STEP 9: Click Register button
        // =====================================================

        By registerButton =
                By.xpath("//button[@type='submit' and normalize-space()='Register']");

        WebElement registerButtonElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));

        System.out.println("Register button is displayed");

        // Wait until Register button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));

        // Move mouse pointer exactly to Register button
        actions.moveToElement(registerButtonElement).perform();

        System.out.println("Mouse pointer moved to Register button");

        Thread.sleep(3000);
        
     // Click Register
        registerButtonElement.click();

        System.out.println("Register button clicked successfully");

        Thread.sleep(3000);


        // =====================================================
        // STEP 10: Verify navigation to Home page
        // =====================================================

        // Wait for page navigation
        wait.until(ExpectedConditions.urlToBe(
                "https://hexaclothes.netlify.app/"
        ));
        
        String homeURL = driver.getCurrentUrl();

        System.out.println("Home page URL: " + homeURL);

        // Verify Home page
        Assert.assertEquals(
                homeURL,
                "https://hexaclothes.netlify.app/",
                "User was not redirected to Home page"
        );

        System.out.println("Registration completed successfully");

        System.out.println("User redirected to Home page successfully");

        Thread.sleep(3000);
    }
    
 // Close browser after every test
    @AfterMethod
    public void tearDown() throws InterruptedException {

        // Keep page visible for 3 seconds
        Thread.sleep(3000);

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed successfully");
    }
}


