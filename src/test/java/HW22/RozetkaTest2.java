package HW22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class RozetkaTest2 {

    public static final String EXCEPTION_TEXT = " :is not present";

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
    public void searchManufacturers(){

        By bySearchInput = By.cssSelector("input[name='search']");
        wait.until(presenceOfElementLocated(bySearchInput)).sendKeys("samsung");
        By searchButton = By.cssSelector("button[class*='button_color_green']");
        wait.until(presenceOfElementLocated(searchButton)).click();

        By mobilePhonesButton = By.xpath("//span[contains(., 'Мобильные телефоны')]");;
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhonesButton)).click();
        By appleCheckbox = By.xpath("//label[contains(., 'Apple')]");
        wait.until(presenceOfElementLocated(appleCheckbox)).click();
        By huaweiCheckbox = By.xpath("//label[contains(., 'Huawei')]");
        wait.until(presenceOfElementLocated(huaweiCheckbox)).click();

        List<WebElement> elementsList = driver.findElements(By.cssSelector("span.goods-title__title"));
        for(WebElement e: elementsList){
            assertTrue(e.getText().contains("Samsung") ||e.getText().contains("Apple") || e.getText().contains("Huawei"));
        }
    }


    @Test
    public void searchByPrice(){
        By bySearchInput = By.cssSelector("input[name='search']");
        By searchButton = By.cssSelector("button[class*='button_color_green']");
        By mobilePhonesButton = By.xpath("//span[contains(., 'Мобильные телефоны')]");
        By minPrice = By.cssSelector("input[formcontrolname='min']");
        By maxPrice = By.cssSelector("input[formcontrolname='max']");
        By submitButton = By.cssSelector("button[class*='button_color_gray']");

        wait.until(presenceOfElementLocated(bySearchInput)).sendKeys("samsung");

        wait.until(presenceOfElementLocated(searchButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhonesButton)).click();

        wait.until(presenceOfElementLocated(minPrice)).clear();
        wait.until(presenceOfElementLocated(minPrice)).sendKeys("5000");

        wait.until(presenceOfElementLocated(maxPrice)).clear();
        wait.until(presenceOfElementLocated(minPrice)).sendKeys("15000");

        wait.until(presenceOfElementLocated(submitButton)).click();

        List<WebElement> elementsList = driver.findElements(By.cssSelector("span.goods-title__price-value"));
        for(WebElement e: elementsList){
            int goodPrice = Integer.parseInt(e.getText().replace("&nbsp", "").replaceAll(" ", ""));
            assertTrue(goodPrice>500 && goodPrice <15000);
        }

    }

    @Test
    public void searchBuiltInMemory(){
        By bySearchInput = By.cssSelector("input[name='search']");
        By searchButton = By.cssSelector("button[class*='button_color_green']");
        By mobilePhonesButton = By.xpath("//span[contains(., 'Мобильные телефоны')]");
        By memoryCheckbox128Gb = By.xpath("//label[contains(., '128 ГБ')]");

        wait.until(presenceOfElementLocated(bySearchInput)).sendKeys("samsung");
        wait.until(presenceOfElementLocated(searchButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhonesButton)).click();
        wait.until(presenceOfElementLocated(memoryCheckbox128Gb)).click();

        List<WebElement> elementsList = driver.findElements(By.cssSelector("span.goods-title__title"));
        for(WebElement e: elementsList){
            assertTrue(e.getText().contains("128GB"), "128GB" + EXCEPTION_TEXT);
        }

    }



}
