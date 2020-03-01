package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        //By.name("q") --> name = "q";
        WebElement search = driver.findElement(By.name("q"));
        //Once we found an element, how to enter text?
        //To enter text, use sendKeys() method
        //how to press Enter after entering the text?
        //use Key.ENTER --> perform keyboard click
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(3000);


        driver.quit();

    }
}
