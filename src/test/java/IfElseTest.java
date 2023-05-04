import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IfElseTest {
    @Test
    public void testPageTitle(){
        System.out.println("Launching Chrome Browser...");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/search");

        WebElement cookies = driver.findElement(By.id("L2AGLb"));
        cookies.click();

        String expPageTitle = "Google";
        boolean flag = false;
        if (driver.getTitle().equalsIgnoreCase(expPageTitle)){
            flag = true;
            System.out.println("Page title match");
        }
        Assert.assertTrue(flag, "Page title does not match with expected");

        driver.quit();
    }

}
