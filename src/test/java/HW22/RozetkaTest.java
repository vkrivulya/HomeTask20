package HW22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

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
    public void monitorComparisonCheck() {
        WebElement laptopsAndComputersLink = wait.until(presenceOfElementLocated(By.linkText("Ноутбуки и компьютеры")));
        Actions hover = new Actions(driver);
        hover.moveToElement(laptopsAndComputersLink).build().perform();
        WebElement monitorsLink = wait.until(presenceOfElementLocated(By.linkText("Мониторы")));
        monitorsLink.click();
        int comparedPrice = 4000;
        findElementsByPrice(driver, comparedPrice);
        WebElement monitorDescription = wait.until(presenceOfElementLocated(By.xpath("//li[contains(., ' Все о товаре ')]")));
        monitorDescription.click();
        WebElement compareButton = wait.until(presenceOfElementLocated(By.xpath("//button[@class='compare-button ng-star-inserted']")));
        compareButton.click();
        WebElement compareAcceptIcon = wait.until(presenceOfElementLocated(By.xpath("//rz-icon-counter//child::span")));
        assertTrue(compareAcceptIcon.isDisplayed());


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void findElementsByPrice(WebDriver driver, int comparedPrice) {
        List<WebElement> elementsList = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        final int counter = 0;
        IntStream.range(0, elementsList.size())
                .filter(i -> Integer.parseInt(elementsList.get(i).getText().replace(" ", "")) < comparedPrice)
                .findFirst()
                .ifPresent(i -> driver.findElement(By.xpath("(//span[@class='goods-tile__price-value']//preceding::a[1])" + "[" + i + 1 + "]")).click());

    }


}
