package Hexa1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HexaClothesCheckoutTest1 {
	
	WebDriver driver;
    WebDriverWait wait;

    String homeURL = "https://hexaclothes.netlify.app/";
    String checkoutURL = "https://hexaclothes.netlify.app/checkout";

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
        
        driver.get(homeURL);

        System.out.println("==========================================");
        System.out.println("Website opened successfully");
        System.out.println("Home Page URL: " + driver.getCurrentUrl());
        System.out.println("==========================================");

        pause(2000);
        
    }


    
 // =========================================================
    // TEST 1: Verify Add Product to Cart
    // =========================================================

    @Test(priority = 1)
    public void verifyAddProductToCart() {

        System.out.println("TEST 1: Add Product to Cart");

        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[contains(normalize-space(), 'Add to Cart')]"
                        )
                )
        );
        
        Assert.assertTrue(
                addToCartButton.isDisplayed(),
                "Add to Cart button is not displayed"
        );

        Assert.assertTrue(
                addToCartButton.isEnabled(),
                "Add to Cart button is not enabled"
        );

        addToCartButton.click();

        System.out.println(
                "PASS: Product added to cart"
        );
    }

 // =========================================================
    // TEST 2: Verify Cart Page
    // =========================================================

    @Test(priority = 2)
    public void verifyCartPage() {

        System.out.println("TEST 2: Verify Cart Page");

        // Add product first
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[contains(normalize-space(), 'Add to Cart')]"
                        )
                )
        );

        addToCartButton.click();

        pause(2000);
        
     // Open Cart
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/cart']")
                )
        );

        cartButton.click();

        wait.until(
                ExpectedConditions.urlContains("/cart")
        );

        String currentURL = driver.getCurrentUrl();

        System.out.println(
                "Current URL: " + currentURL
        );

        Assert.assertTrue(
                currentURL.contains("/cart"),
                "Cart page was not opened"
        );

        System.out.println(
                "PASS: Cart page opened successfully"
        );
    }

    // =========================================================
    // TEST 3: Verify Initial Quantity
    // =========================================================

    @Test(priority = 3)
    public void verifyInitialQuantity() {

        System.out.println("TEST 3: Verify Initial Quantity");

        // Add product
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[contains(normalize-space(), 'Add to Cart')]"
                        )
                )
        );

        addToCartButton.click();
        
        pause(2000);

        // Open Cart
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/cart']")
                )
        );

        cartButton.click();

        wait.until(
                ExpectedConditions.urlContains("/cart")
        );

        // Find quantity
        WebElement quantity = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//span[@class='px-4 py-2 bg-gray-100 border']"
                        )
                )
        );
        
        String initialQuantity = quantity.getText();

        System.out.println(
                "Initial product quantity: "
                        + initialQuantity
        );

        Assert.assertEquals(
                initialQuantity,
                "1",
                "Initial product quantity is not 1"
        );

        System.out.println(
                "PASS: Initial product quantity is 1"
        );
    }

    // =========================================================
    // TEST 4: Verify Proceed to Checkout
    // =========================================================
    
    @Test(priority = 4)
    public void verifyProceedToCheckout() {

        System.out.println(
                "TEST 4: Verify Proceed to Checkout"
        );

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        // Add product
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[contains(normalize-space(), 'Add to Cart')]"
                        )
                )
        );

        addToCartButton.click();

        pause(2000);
        
     // Open Cart
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/cart']")
                )
        );

        cartButton.click();

        wait.until(
                ExpectedConditions.urlContains("/cart")
        );

        // Find Proceed to Checkout
        WebElement proceedToCheckout = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Proceed to Checkout']"
                        )
                )
        );
        
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                proceedToCheckout
        );

        pause(1000);

        Assert.assertTrue(
                proceedToCheckout.isDisplayed(),
                "Proceed to Checkout button is not displayed"
        );

        Assert.assertTrue(
                proceedToCheckout.isEnabled(),
                "Proceed to Checkout button is not enabled"
        );

        proceedToCheckout.click();

        wait.until(
                ExpectedConditions.urlToBe(checkoutURL)
        );
        
        Assert.assertEquals(
                driver.getCurrentUrl(),
                checkoutURL,
                "Checkout page was not opened"
        );

        System.out.println(
                "PASS: Proceed to Checkout successfully opened Checkout page"
        );
    }

    // =========================================================
    // TEST 5: Verify Checkout Page
    // =========================================================

    @Test(priority = 5)
    public void verifyCheckoutPage() {

        System.out.println(
                "TEST 5: Verify Checkout Page"
        );
        
     // Add product
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[contains(normalize-space(), 'Add to Cart')]"
                        )
                )
        );

        addToCartButton.click();

        pause(2000);

        // Open Cart
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/cart']")
                )
        );
        
        cartButton.click();

        wait.until(
                ExpectedConditions.urlContains("/cart")
        );

        // Proceed to Checkout
        WebElement proceedToCheckout = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Proceed to Checkout']"
                        )
                )
        );

        proceedToCheckout.click();

        wait.until(
                ExpectedConditions.urlToBe(checkoutURL)
        );

        String actualCheckoutURL =
                driver.getCurrentUrl();
        
        System.out.println(
                "Checkout URL: " + actualCheckoutURL
        );

        Assert.assertEquals(
                actualCheckoutURL,
                checkoutURL,
                "Checkout page was not opened"
        );

        System.out.println(
                "PASS: Checkout page opened successfully"
        );
    }

    // =========================================================
    // TEST 6: Verify Card Number Accepts Alphabets
    // =========================================================
    
    @Test(priority = 6)
    public void verifyCardNumberField() {

        System.out.println(
                "TEST 6: Enter Alphabets in Card Number"
        );

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        // Navigate to Checkout
        navigateToCheckout();

        // Find Card Number
        WebElement cardNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//input[@placeholder='Card Number']"
                        )
                )
        );
        
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                cardNumber
        );

        pause(1000);

        cardNumber.click();

        cardNumber.sendKeys("ABCDEFGH");

        System.out.println(
                "Entered Card Number: ABCDEFGH"
        );

        // Verify entered value
        String enteredValue =
                cardNumber.getAttribute("value");

        System.out.println(
                "Actual Card Number value: "
                        + enteredValue
        );
        
        Assert.assertEquals(
                enteredValue,
                "ABCDEFGH",
                "Entered alphabets were not present in Card Number field"
        );

        System.out.println(
                "PASS: Alphabets entered in Card Number field"
        );
    }

    // =========================================================
    // TEST 7: Verify Place Order Button
    // =========================================================

    @Test(priority = 7)
    public void verifyPlaceOrderButton() {

        System.out.println(
                "TEST 7: Verify Place Order Button"
        );
        
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        navigateToCheckout();

        WebElement placeOrder = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Place Order']"
                        )
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                placeOrder
        );

        pause(1000);
        
        Assert.assertTrue(
                placeOrder.isDisplayed(),
                "Place Order button is not displayed"
        );

        Assert.assertTrue(
                placeOrder.isEnabled(),
                "Place Order button is not enabled"
        );

        System.out.println(
                "PASS: Place Order button is displayed and enabled"
        );
    }

    // =========================================================
    // TEST 8: Verify Place Order Redirection
    // =========================================================
    
    @Test(priority = 8)
    public void verifyPlaceOrderRedirection() {

        System.out.println(
                "TEST 8: Verify Place Order Redirection"
        );

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        navigateToCheckout();

        WebElement placeOrder = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Place Order']"
                        )
                )
        );
        
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                placeOrder
        );

        pause(1000);

        placeOrder.click();

        System.out.println(
                "Place Order button clicked"
        );

        pause(3000);

        String actualHomeURL =
                driver.getCurrentUrl();

        System.out.println(
                "Current URL after Place Order: "
                        + actualHomeURL
        );
        
        Assert.assertEquals(
                actualHomeURL,
                homeURL,
                "User was not redirected to Home page"
        );

        System.out.println(
                "PASS: User was redirected to Home page"
        );
    }

    // =========================================================
    // COMMON METHOD: Navigate to Checkout
    // =========================================================

    public void navigateToCheckout() {

        // Add product
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[contains(normalize-space(), 'Add to Cart')]"
                        )
                )
        );
        
        addToCartButton.click();

        pause(2000);

        // Open Cart
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/cart']")
                )
        );

        cartButton.click();

        wait.until(
                ExpectedConditions.urlContains("/cart")
        );
        
     // Proceed to Checkout
        WebElement proceedToCheckout = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Proceed to Checkout']"
                        )
                )
        );

        proceedToCheckout.click();

        wait.until(
                ExpectedConditions.urlToBe(checkoutURL)
        );

        System.out.println(
                "Successfully navigated to Checkout page"
        );
    }
    
 // =========================================================
    // PAUSE METHOD
    // =========================================================

    public void pause(long milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    // =========================================================
    // TEARDOWN
    // =========================================================
    
    @AfterMethod
    public void tearDown() {

        pause(2000);

        if (driver != null) {
            driver.quit();
        }

        System.out.println(
                "Browser closed"
        );
    }
}
