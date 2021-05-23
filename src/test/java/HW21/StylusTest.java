package HW21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class StylusTest {

    private WebDriver driver;
    private WebDriverWait wait;

    String textForSearchresult = "iphone kyiv buy";
    int maxPageNumber = 5;
    String expectedText = "stylus.ua";
    private String homeUrl = "https://google.com/ncr";


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
    public void googleSearchTest() throws Exception {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(textForSearchresult + Keys.ENTER);
        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));

        aa:
        for (int i =1; i<=maxPageNumber; i++ ){
            List<WebElement> searchResult = Collections.singletonList(driver.findElement(By.cssSelector("div cite")));
            bb:
            for (WebElement element:searchResult){
                if (element.getText().contains(expectedText)){
                    System.out.println("[" + expectedText + "] was found on page number " + i);
                    break aa;
                }
            }
            driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
            if (maxPageNumber ==i){
                throw new Exception("[" + expectedText + "] was not found on " + maxPageNumber + " pages");
            }
        }






    }


}
