package HW23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class IframesTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private final String homeUrl = "http://demo.guru99.com/test/guru99home/";

    public boolean isElementPresent(By by) {
        try {
            driver.findElements(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

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
    public void switchIframes(){
        driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);

        WebElement playButton = wait.until(presenceOfElementLocated(By.cssSelector("[class*='large-play-button ytp']")));
        playButton.click();


        WebElement stopButton = wait.until(presenceOfElementLocated(By.cssSelector("[class*='ytp-play-button']")));
        stopButton.click();



        assertTrue(isElementPresent(By.cssSelector("[class*='ytp-play-button']")));

        driver.switchTo().parentFrame();
        assertTrue(isElementPresent(By.cssSelector("[class*='ytp-play-button']")));



    }



}
