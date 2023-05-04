import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TemaInputField {
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

    @Test ( priority = 1)
    public void single(){
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("user-message")).sendKeys("Test");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(true, yourMessage.isDisplayed());

    }

    @Test ( priority = 2)
    public void multiple(){
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("Test");
        driver.findElement(By.id("sum2")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals("NaN", "NaN");
    }

    @Test ( priority = 3)
    public void multiple2(){
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("5");
        driver.findElement(By.id("sum2")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(10,10);

    }

    @Test ( priority = 4)
    public void multiple3(){
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("a");
        driver.findElement(By.id("sum2")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals("NaN", "NaN");

    }
}
