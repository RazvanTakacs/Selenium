import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TemaCheckbox {
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
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        driver.findElement(By.id("isAgeSelected")).click();
        WebElement yourMessage = driver.findElement(By.id("txtAge"));
        Assert.assertEquals(true, yourMessage.isDisplayed());

    }

    @Test (priority = 2)
    public void multiple(){
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        WebElement option = driver.findElement(By.id("ex1-check1"));
        option.click();
        if(option.isSelected()) {
            System.out.println("Checkbox is Toggled On");
        }else{
            System.out.println("Checkbox is Toggled Off");
        }

    }

    @Test (priority = 3)
    public void multiple2(){
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        driver.findElement(By.id("box")).click();
        WebElement checkAllButton = driver.findElement(By.id("box"));
        String buttonValue = checkAllButton.getAttribute("value");
        Assert.assertEquals(buttonValue, "uncheck all");


    }

    @Test (priority =  4)
    public void multiple3(){
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        driver.findElement(By.id("ex1-check1")).click();
        driver.findElement(By.id("ex1-check2")).click();
        driver.findElement(By.id("ex1-check3")).click();
        driver.findElement(By.id("ex1-check4")).click();
        WebElement checkAllButton = driver.findElement(By.id("box"));
        String buttonValue = checkAllButton.getAttribute("value");
        Assert.assertEquals(buttonValue, "uncheck all");
    }
}
