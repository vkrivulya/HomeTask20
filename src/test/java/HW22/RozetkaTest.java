//package HW22;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.stream.IntStream;
//
//import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
//import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//public class RozetkaTest {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    private String homeUrl = "https://rozetka.com.ua";
//
//    @BeforeClass
//    public void setupBrowser() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);
//    }
//
//    @AfterClass
//    public void closeBrowser() {
//        driver.quit();
//    }
//
//    @BeforeMethod
//    public void navigateAction() {
//        driver.get(homeUrl);
//    }
//
//    @Test
//    public void monitorComparisonCheck() {
//        By byMonitorDescription = By.xpath("//li[contains(., ' Все о товаре ')]");
//        By byCompareButton = By.xpath("//button[@class='compare-button ng-star-inserted']");
//        By byCounterCompareList = By.xpath("//rz-icon-counter//child::span");
//        By byProductPrices = By.cssSelector("div[class='product__prices']");
//        int comparedPrice;
//        WebElement laptopsAndComputersLink = wait.until(presenceOfElementLocated(By.linkText("Ноутбуки и компьютеры")));
//        Actions hover = new Actions(driver);
//        hover.moveToElement(laptopsAndComputersLink).build().perform();
//        WebElement monitorsLink = wait.until(presenceOfElementLocated(By.linkText("Мониторы")));
//        monitorsLink.click();
//        comparedPrice = 4000;
//        findElementsByPrice(driver, comparedPrice);
//        wait.until(presenceOfElementLocated(byMonitorDescription)).click();
//        wait.until(presenceOfElementLocated(byCompareButton)).click();
//        wait.until(presenceOfElementLocated(byCounterCompareList));
//        assertTrue(driver.findElement(byCounterCompareList).isDisplayed());
//
//        String monitorTitle = getMonitorTitle(driver);
//        int monitorPrice = getMonitorPrice(driver);
//
//        driver.navigate().back();
//        driver.navigate().back();
//
//        wait.until(presenceOfElementLocated(By.cssSelector("h1[class='catalog-heading ng-star-inserted']")));
//        comparedPrice = monitorPrice;
//        findElementsByPrice(driver, comparedPrice);
//        wait.until(presenceOfElementLocated(byMonitorDescription)).click();
//        wait.until(presenceOfElementLocated(byCompareButton)).click();
//        wait.until(textToBePresentInElementLocated(byCounterCompareList, "2"));
//        assertEquals(Integer.parseInt(driver.findElement(byCounterCompareList).getText()), "2");
//
//        String secondMonitorTitle = getMonitorTitle(driver);
//        int secondMonitorPrice = getMonitorPrice(driver);
//
//        driver.findElement(By.cssSelector("li[class='header-action__item header-action__item--comparison'] button")).click();
//        driver.findElement(By.cssSelector("a.comparison-modal__link")).click();
//
//        wait.until(presenceOfElementLocated(byProductPrices));
//        List<WebElement> priceElementsList = driver.findElements(byProductPrices);
//        assertEquals(priceElementsList.size(), "2");
//
//    }
//
//    public static String getMonitorTitle(WebDriver driver) {
//        return driver.findElement(By.cssSelector("h1[class='product__title']")).getText();
//    }
//
//    public static int getMonitorPrice(WebDriver driver) {
//        return Integer.parseInt(driver.findElement(By.cssSelector("p.product-prices__big")).getText()
//                .replace("&nbsp", "")
//                .replaceAll(" ", "")
//                .replace("₴", "")
//        );
//    }
//
//
//    public void findElementsByPrice(WebDriver driver, int comparedPrice) {
//        List<WebElement> elementsList = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        IntStream.range(0, elementsList.size())
//                .filter(i -> Integer.parseInt(elementsList.get(i).getText().replace(" ", "")) < comparedPrice)
//                .findFirst()
//                .ifPresent(i -> driver.findElement(By.xpath("(//span[@class='goods-tile__price-value']//preceding::a[1])" + "[" + i + 1 + "]")).click());
//    }
//
//
//}
