import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleFormDemo {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("web-driver.chrome.driver", "Z:\\QA\\Chromadriver\\chromedriver.exe\\");
        driver = new ChromeDriver();
    }

    @AfterTest
   public void teardown() {
        driver.quit();
    }

    @Test (priority = 1)
    public void singleImputField(){
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("user-message")).sendKeys("Test");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(true, yourMessage.isDisplayed());
    }

    @Test (priority = 2)
    public void checkThatTheInputFieldIsEmpty(){
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(false, yourMessage.isDisplayed());
        System.out.println("No user input");
    }
}
