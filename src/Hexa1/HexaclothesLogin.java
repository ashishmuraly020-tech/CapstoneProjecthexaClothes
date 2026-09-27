package Hexa1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HexaclothesLogin {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://hexaclothes.netlify.app/");

        Thread.sleep(2000);

        driver.manage().window().maximize();

        System.out.println("Website opened successfully");
    }
        
    @Test
    public void loginTest() {

        System.out.println("Login test executed successfully");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

        System.out.println("Browser closed successfully");
    }
}


