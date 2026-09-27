package Hexa1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HexaClothesWishlisttest1 {
	
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        driver.get("https://hexaclothes.netlify.app/");
        Thread.sleep(2000);
        System.out.println("Website opened successfully");
    }
    
    @Test(priority = 1)
    public void test01_ClickLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();
        Thread.sleep(2000);
        System.out.println("Step 1: Login button clicked successfully");
    }

    @Test(priority = 2, dependsOnMethods = "test01_ClickLoginButton")
    public void test02_EnterEmail() throws InterruptedException {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailInput.sendKeys("ashishmuraly020@gmail.com");
        Thread.sleep(2000);
        System.out.println("Step 2: Email entered successfully");
    }

    @Test(priority = 3, dependsOnMethods = "test02_EnterEmail")
    public void test03_EnterPassword() throws InterruptedException {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Ashish123");
        Thread.sleep(2000);
        System.out.println("Step 3: Password entered successfully");
    }
    
    @Test(priority = 4, dependsOnMethods = "test03_EnterPassword")
    public void test04_ClickLoginSubmit() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit' and normalize-space()='Login']")).click();
        Thread.sleep(2000);
        System.out.println("Step 4: Login submit button clicked successfully");
    }

    @Test(priority = 5, dependsOnMethods = "test04_ClickLoginSubmit")
    public void test05_ClickAllProducts() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/all' and normalize-space()='All Products']"))).click();
        Thread.sleep(2000);
        System.out.println("Step 5: All Products clicked successfully");
    }
    
    @Test(priority = 6, dependsOnMethods = "test05_ClickAllProducts")
    public void test06_SelectFirstProduct() throws InterruptedException {
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/assets/men1-BtrJM-0i.webp']")));
        firstProduct.click();
        Thread.sleep(2000);
        System.out.println("Step 6: First product selected successfully");
    }

    @Test(priority = 7, dependsOnMethods = "test06_SelectFirstProduct")
    public void test07_ScrollToProductWishlistButton() throws InterruptedException {
        WebElement productWishlistBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'border-black')]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", productWishlistBtn);
        Thread.sleep(2000);
        System.out.println("Step 7: Scrolled down to Wishlist heart button successfully");
    }
    
    @Test(priority = 8, dependsOnMethods = "test07_ScrollToProductWishlistButton")
    public void test08_ClickProductWishlistButton() throws InterruptedException {
        WebElement productWishlistBtn = driver.findElement(By.xpath("//button[contains(@class, 'border-black')]"));
        productWishlistBtn.click();
        Thread.sleep(2000);
        System.out.println("Step 8: Product added to Wishlist successfully");
    }

    @Test(priority = 9, dependsOnMethods = "test08_ClickProductWishlistButton")
    public void test09_ScrollToTop() throws InterruptedException {
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);
        System.out.println("Step 9: Scrolled back up to top successfully");
    }
    
    @Test(priority = 10, dependsOnMethods = "test09_ScrollToTop")
    public void test10_WaitForToastNotification() throws InterruptedException {
        // Pause to ensure the Toastify alert overlay disappears fully
        Thread.sleep(3000);
        System.out.println("Step 10: Toast notification cleared successfully");
    }

    @Test(priority = 11, dependsOnMethods = "test10_WaitForToastNotification")
    public void test11_ClickHeaderWishlistIcon() throws InterruptedException {
        WebElement headerWishlistBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//*[name()='svg' and contains(@class, 'bg-orange-600')]/parent::* | //*[name()='svg' and contains(@class, 'bg-orange-600')]")
            )
        );
        
        try {
            headerWishlistBtn.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true}));", headerWishlistBtn);
        }

        Thread.sleep(2000);
        System.out.println("Step 11: Header Wishlist icon clicked successfully");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}


