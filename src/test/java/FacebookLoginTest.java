import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FacebookLoginTest {
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

    @Test
    public void testFacebookLogin(){
        driver.get("https://www.facebook.com/");

        //Accept cookies
        try {
            WebElement acceptAllCookiesBtn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath
                    ("//button[contains(., 'Allow')]")));
        acceptAllCookiesBtn.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found");
        }

        //Login
        driver.findElement(By.id("email")).sendKeys("facebook_email");
        driver.findElement(By.id("pass")).sendKeys("facebook_password");
        driver.findElement(By.name("login")).click();

        //Verify login
        WebElement element = driver.findElement(By.linkText("Find your account and log in."));
        Assert.assertEquals(true, element.isDisplayed());

    }
}