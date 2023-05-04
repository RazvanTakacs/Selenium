//navigati pe google, faceti o cautare dupa orice doriti si dati click pe sectiunea de imagini
        //navigati pe google, faceti o cautare dupa orice doriti si dati click pe primul rezultat
        //navigati pe google, faceti o cautare dupa orice doriti si stergeti ce ati cautat folosind butonul x din bara de search


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class Tema {

   public String baseUrl = "http://www.google.com/";
    public WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void beforeTest(){
        driver.get(baseUrl);
        WebElement cookies = driver.findElement(By.id("L2AGLb"));
        cookies.click();

    }

    @Test
    public void imagine(){
        System.out.println("Test imagine");
        driver.get(baseUrl);
//        WebElement cookies = driver.findElement(By.id("L2AGLb"));
//        cookies.click();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("bike");
        element.submit();
        WebElement images = driver.findElement(By.xpath("/html/body/div[7]/div/div[4]/div/div[1]/div/div[1]/div/div[2]/a"));
        images.click();
//      driver.quit();

    }


    @Test
    public void link() {
        System.out.println("Test link");
        driver.get(baseUrl);
//        WebElement cookies = driver.findElement(By.id("L2AGLb"));
//        cookies.click();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("maros bike");
        element.submit();
        WebElement link = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        link.click();
//      driver.quit();
    }

    @Test
    public void close() {
        System.out.println("Test close");
        driver.get(baseUrl);
//        WebElement cookies = driver.findElement(By.id("L2AGLb"));
//        cookies.click();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("bike");
        element.submit();
        WebElement close = driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div[1]/div[1]/div[2]/div/div[3]/div[1]/div"));
        close.click();
//      driver.quit();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}