package Hexa1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HexaclothesAddToCartTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://hexaclothes.netlify.app/");

        System.out.println("Website opened successfully");
    }
    
    @Test
    public void addProductToCart() throws InterruptedException {

       

        WebElement addToCartButton = driver.findElement(
                By.xpath("//button[contains(normalize-space(), 'Add to Cart')]")
        );

        addToCartButton.click();

        Thread.sleep(2000);

        System.out.println("Product added to cart");
        
 
        
        WebElement cartButton = driver.findElement(
                By.xpath("//a[@href='/cart']")
        );

        cartButton.click();

        Thread.sleep(3000);

        System.out.println("Cart page opened successfully");
        
   

        String currentURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentURL);

        Assert.assertTrue(
                currentURL.contains("/cart"),
                "Cart page was not opened"
        );

        System.out.println("PASS: User successfully navigated to Cart page");
        


        WebElement quantityBefore = driver.findElement(
                By.xpath("//span[@class='px-4 py-2 bg-gray-100 border']")
        );

        String initialQuantity = quantityBefore.getText();

        System.out.println("Initial product quantity: " + initialQuantity);

        Assert.assertEquals(
                initialQuantity,
                "1",
                "Initial product quantity is not 1"
        );

        System.out.println("PASS: Initial product quantity is 1");
   

        WebElement plusButton = driver.findElement(
                By.xpath("//button[contains(@class,'rounded-r')]")
        );

        plusButton.click();

        Thread.sleep(2000);

        System.out.println("Plus button clicked successfully");
        
    

        WebElement quantityAfter = driver.findElement(
                By.xpath("//span[normalize-space()='2']")
        );

        String updatedQuantity = quantityAfter.getText();

        System.out.println("Updated product quantity: " + updatedQuantity);
        


        Assert.assertEquals(
                updatedQuantity,
                "2",
                "Product quantity was not increased from 1 to 2"
        );

        System.out.println(
                "PASS: Product quantity increased successfully from 1 to 2"
        );
    

     WebElement minusButton = driver.findElement(
             By.xpath("//button[contains(@class,'rounded-l')]")
     );

     minusButton.click();

     Thread.sleep(2000);

     System.out.println("Minus button clicked successfully");


    
     WebElement quantityDecreased = driver.findElement(
             By.xpath("//span[normalize-space()='1']")
     );

     String decreasedQuantity = quantityDecreased.getText();

     System.out.println("Decreased product quantity: " + decreasedQuantity);
  
     Assert.assertEquals(
             decreasedQuantity,
             "1",
             "Product quantity was not decreased from 2 to 1"
     );

     System.out.println(
             "PASS: Product quantity decreased successfully from 2 to 1"
     );
     
 

  WebElement removeButton = driver.findElement(
          By.xpath("//button[normalize-space()='Remove']")
  );

  removeButton.click();

  Thread.sleep(2000);

  System.out.println("Remove button clicked successfully");
  

WebElement emptyCartMessage = driver.findElement(
       By.xpath("//*[normalize-space()='Your cart is empty']")
);

Assert.assertTrue(
       emptyCartMessage.isDisplayed(),
       "Cart is not empty after removing the product"
);

System.out.println(
       "PASS: Product removed successfully and cart is empty"
);
        
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();

        System.out.println("Browser closed successfully");
    }
    
    }
		




