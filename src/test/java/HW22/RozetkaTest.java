package HW22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RozetkaTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private String homeUrl = "https://rozetka.com.ua";

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @BeforeMethod
    public void navigateAction() {
        driver.get(homeUrl);
    }

    @Test
    public void monitorComparisonCheck(){
        WebElement laptopsAndComputersLink = wait.until(presenceOfElementLocated(By.linkText("Ноутбуки и компьютеры")));
        Actions hover = new Actions(driver);
        hover.moveToElement(laptopsAndComputersLink).build().perform();
//        driver.findElement(By.name("btnLogin")).click();
        WebElement monitorsLink = wait.until(presenceOfElementLocated(By.linkText("Мониторы")));
        monitorsLink.click();

    }


}
