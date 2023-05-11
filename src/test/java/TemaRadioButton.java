import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TemaRadioButton {
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
    public void simple(){
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.name("optradio")).click();
        driver.findElement(By.id("buttoncheck")).click();
        WebElement male_radio_button=driver.findElement(By.name("optradio"));
        boolean enabled_status=male_radio_button.isEnabled();
        System.out.println("Male radio button is Enabled >>"+enabled_status);
    }

    @Test
    public void simple2(){
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.id("buttoncheck")).click();
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[3]/div/div/div[2]/div[1]/div[2]/p[2]"));
        String messageText = errorMessage.getText();
        Assert.assertEquals("Radio button is Not checked", messageText);
    }

    @Test (priority = 3)
    public void groupRadio(){
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/label[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/label[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/button")).click();
        WebElement element = driver.findElement(By.className("genderbutton"));
        Assert.assertEquals(true, element.isDisplayed());
        WebElement element2 = driver.findElement(By.className("groupradiobutton"));
        Assert.assertEquals(true, element2.isDisplayed());
    }


}
