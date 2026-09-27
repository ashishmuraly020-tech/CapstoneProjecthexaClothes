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

public class HexaClothesOrdernowTest3 {
	
	WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://hexaclothes.netlify.app/");

        Thread.sleep(2000);

        System.out.println("Website opened successfully");
    }
    
 // =========================================================
    // TEST 1: Verify second product selection
    // =========================================================

    @Test(priority = 1)
    public void verifySecondProductSelection() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement secondImage = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//img[@src='/assets/TS2-BdDMbp6W.png']")
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                secondImage
        );

        Thread.sleep(1000);
        
        wait.until(
                ExpectedConditions.elementToBeClickable(secondImage)
        );

        secondImage.click();

        System.out.println("Second product image selected");

        Assert.assertTrue(
                secondImage.isDisplayed(),
                "Second product image was not displayed"
        );

        System.out.println("PASS: Second product selected");
    }

    // =========================================================
    // TEST 2: Verify Order Now button
    // =========================================================
    
    @Test(priority = 2)
    public void verifyOrderNowButton() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement secondImage = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//img[@src='/assets/TS2-BdDMbp6W.png']")
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                secondImage
        );

        Thread.sleep(1000);

        WebElement orderNowButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                		
                		By.xpath(
                                "//img[@src='/assets/TS2-BdDMbp6W.png']"
                                + "/ancestor::div[.//button[contains(normalize-space(),'Order now')]][1]"
                                + "//button[contains(normalize-space(),'Order now')]"
                        )
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                orderNowButton
        );

        Thread.sleep(500);

        Assert.assertTrue(
                orderNowButton.isDisplayed(),
                "Order Now button is not displayed"
        );

        Assert.assertTrue(
                orderNowButton.isEnabled(),
                "Order Now button is not enabled"
        );
        
        System.out.println("PASS: Order Now button is displayed and enabled");
    }

    // =========================================================
    // TEST 3: Verify Order Now navigation to Cart
    // =========================================================

    @Test(priority = 3)
    public void verifyOrderNowNavigation() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement secondImage = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//img[@src='/assets/TS2-BdDMbp6W.png']")
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                secondImage
        );

        Thread.sleep(1000);
        
        WebElement orderNowButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//img[@src='/assets/TS2-BdDMbp6W.png']"
                                + "/ancestor::div[.//button[contains(normalize-space(),'Order now')]][1]"
                                + "//button[contains(normalize-space(),'Order now')]"
                        )
                )
        );

        orderNowButton.click();

        System.out.println("Order Now button clicked");

        Thread.sleep(3000);

        js.executeScript("window.scrollTo(0, 0);");

        Thread.sleep(1000);

        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/cart']")
                )
        );
        
        cartButton.click();

        Thread.sleep(3000);

        String currentURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentURL);

        Assert.assertTrue(
                currentURL.contains("/cart"),
                "Cart page was not opened"
        );

        System.out.println(
                "PASS: Order Now successfully navigated to Cart page"
        );
    }

    // =========================================================
    // TEST 4: Verify quantity increase from 1 to 2
    // =========================================================
    
    @Test(priority = 4)
    public void verifyQuantityIncrease() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // STEP 1: Select second product

        WebElement secondImage = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//img[@src='/assets/TS2-BdDMbp6W.png']")
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                secondImage
        );

        Thread.sleep(1000);

        System.out.println("Second product found");
        
     // STEP 2: Find Order Now button

        WebElement orderNowButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//img[@src='/assets/TS2-BdDMbp6W.png']"
                                + "/ancestor::div[.//button[contains(normalize-space(),'Order now')]][1]"
                                + "//button[contains(normalize-space(),'Order now')]"
                        )
                )
        );

     // STEP 3: Click Order Now

        orderNowButton.click();

        System.out.println("Order Now button clicked");

        Thread.sleep(3000);

        // STEP 4: Go to Cart

        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/cart']")
                )
        );
        
        cartButton.click();

        Thread.sleep(3000);

        // STEP 5: Verify Cart page

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/cart"),
                "Cart page was not opened"
        );

        System.out.println("Cart page opened successfully");

        // STEP 6: Get current quantity

        WebElement quantity = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//button[contains(@class,'bg-gray-200')]/preceding-sibling::span"
                        )
                )
        );
        
        String initialQuantity = quantity.getText();

        System.out.println(
                "Initial quantity: " + initialQuantity
        );

        // Verify initial quantity is 1

        Assert.assertEquals(
                initialQuantity,
                "1",
                "Initial quantity is not 1"
        );

        System.out.println("PASS: Initial quantity is 1");

        // STEP 7: Click PLUS button

        WebElement plusButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[contains(@class,'bg-gray-200') and contains(@class,'rounded-r')]"
                        )
                )
        );
        
        plusButton.click();

        Thread.sleep(1500);

        System.out.println("Plus button clicked");

        // STEP 8: Verify quantity changed to 2

        WebElement updatedQuantity = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//button[contains(@class,'bg-gray-200')]/preceding-sibling::span"
                        )
                )
        );

        String finalQuantity = updatedQuantity.getText();

        System.out.println(
                "Updated quantity: " + finalQuantity
        );
        
        Assert.assertEquals(
                finalQuantity,
                "2",
                "Quantity was not increased from 1 to 2"
        );

        System.out.println(
                "PASS: Product quantity successfully increased from 1 to 2"
        );
    }
            

            // =========================================================
            // TEARDOWN
            // =========================================================
    
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed successfully");
    }
}


