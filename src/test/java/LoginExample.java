import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginExample {
    @Test
    public void login(){
        System.setProperty("web-driver.chrome.driver", "Z:\\QA\\Chromadriver\\chromedriver.exe\\" );
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement username = driver.findElement(By.id("user_email_login"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement login = driver.findElement(By.name("commit"));
        WebElement coockies = driver.findElement(By.id("accept-cookie-notification"));

        coockies.click();
        username.sendKeys("user@gmail.com");
        password.sendKeys("12345");


        login.click();

        String expectedResult = String.valueOf(driver.findElement(By.xpath("//*[@id=\"signin_signup_form\"]/div[1]/div/div[1]/fieldset/div[5]/div/div/div/span")));
        String actualResult = String.valueOf(driver.findElement(By.xpath("//*[@id=\"signin_signup_form\"]/div[1]/div/div[1]/fieldset/div[5]/div/div/div/span")));

        Assert.assertEquals(expectedResult,actualResult);

        driver.quit();
    }


}
