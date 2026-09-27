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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HexaClothesExploreNowTest {
	
	WebDriver driver;
    WebDriverWait wait;
    String homeUrl = "https://hexaclothes.netlify.app/";

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(homeUrl);
        Thread.sleep(2000); // Pause after launch
        System.out.println("Website opened successfully");
    }

    // =====================================================
    // HELPER METHODS
    // =====================================================
    
    /**
     * Safely locates and clicks the visible 'Explore Now' button
     */
    public void clickExploreButton() throws InterruptedException {
        By exploreNowXpath = By.xpath("//button[normalize-space()='Explore Now']");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(exploreNowXpath));

        WebElement exploreButton = null;
        for (WebElement element : driver.findElements(exploreNowXpath)) {
            if (element.isDisplayed()) {
                exploreButton = element;
                break;
            }
        }
        
        Assert.assertNotNull(exploreButton, "Visible Explore Now button was not found");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", exploreButton);
        Thread.sleep(1000); // Visual pause before click
        wait.until(ExpectedConditions.elementToBeClickable(exploreButton));

        try {
            exploreButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", exploreButton);
        }

        System.out.println("Explore Now clicked successfully");
        Thread.sleep(2000); // Visual pause after click
    }
    
 // =====================================================
    // TEST CASES
    // =====================================================

    @Test(priority = 1)
    public void clickExploreNow() throws InterruptedException {
        clickExploreButton();

        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(homeUrl)));
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL after Explore Now: " + currentUrl);
        Assert.assertNotEquals(currentUrl, homeUrl, "All Products page was not opened");
        
        Thread.sleep(3000); // Pause before ending Test 1
    }
    
    @Test(priority = 2)
    public void clickHomeIcon() throws InterruptedException {
        By homeIcon = By.xpath("//a[@href='/']");

        WebElement home = wait.until(ExpectedConditions.elementToBeClickable(homeIcon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", home);
        Thread.sleep(1000); // Visual pause before clicking home icon
        
        home.click();

        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlToBe(homeUrl),
            ExpectedConditions.urlToBe("https://hexaclothes.netlify.app")
        ));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Home icon clicked successfully. Current URL: " + currentUrl);
        
        Thread.sleep(3000); // Pause before ending Test 2
    }
    
    @Test(priority = 3)
    public void clickTopRated() throws InterruptedException {
        driver.get(homeUrl);
        Thread.sleep(2000); // Pause after page load
        clickExploreButton();

        By topRated = By.xpath("//a[@href='/tr' and normalize-space()='Top Rated']");
        WebElement topRatedElement = wait.until(ExpectedConditions.elementToBeClickable(topRated));
        Thread.sleep(1000); // Visual pause before click
        
        topRatedElement.click();

        wait.until(ExpectedConditions.urlContains("/tr"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/tr"), "Top Rated page was not opened");
        
        Thread.sleep(3000); // Pause before ending Test 3
    }
    
    @Test(priority = 4)
    public void clickKidsWear() throws InterruptedException {
        driver.get(homeUrl);
        Thread.sleep(2000); // Pause after page load
        clickExploreButton();

        By kidsWear = By.xpath("//a[@href='/kids' and normalize-space()='Kids Wear']");
        WebElement kids = wait.until(ExpectedConditions.elementToBeClickable(kidsWear));
        Thread.sleep(1000); // Visual pause before click
        
        kids.click();

        wait.until(ExpectedConditions.urlContains("/kids"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/kids"), "Kids Wear page was not opened");
        
        Thread.sleep(3000); // Pause before ending Test 4
    }
    
    @Test(priority = 5)
    public void clickMensWear() throws InterruptedException {
        driver.get(homeUrl);
        Thread.sleep(2000); // Pause after page load
        clickExploreButton();

        By mensWear = By.xpath("//a[@href='/mens' and normalize-space()='Mens Wear']");
        WebElement mens = wait.until(ExpectedConditions.elementToBeClickable(mensWear));
        Thread.sleep(1000); // Visual pause before click
        
        mens.click();

        wait.until(ExpectedConditions.urlContains("/mens"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/mens"), "Mens Wear page was not opened");
        
        Thread.sleep(3000); // Pause before ending Test 5
    }
    
    @Test(priority = 6)
    public void clickWomensWear() throws InterruptedException {
        driver.get(homeUrl);
        Thread.sleep(2000); // Pause after page load
        clickExploreButton();

        By womensWear = By.xpath("//a[@href='/women' and normalize-space()=\"Women's Wear\"]");
        WebElement women = wait.until(ExpectedConditions.elementToBeClickable(womensWear));
        Thread.sleep(1000); // Visual pause before click
        
        women.click();

        wait.until(ExpectedConditions.urlContains("/women"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/women"), "Women's Wear page was not opened");
        
        Thread.sleep(3000); // Pause before ending Test 6
    }
    
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000); // Final pause before shutting down the browser session
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Browser closed successfully");
    }
}




    

