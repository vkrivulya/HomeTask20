package HW24.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class MonitorPage extends RozetkaBasePage {

    By byMonitorDescription = By.xpath("//li[contains(., ' Все о товаре ')]");
    By byCompareButton = By.xpath("//button[@class='compare-button ng-star-inserted']");
    By byCounterCompareList = By.xpath("//rz-icon-counter//child::span");
    By comparisonButton = By.cssSelector("li[class='header-action__item header-action__item--comparison'] button");
    By comparisonModalLink = By.cssSelector("a.comparison-modal__link");


    public void clickMonitorDescription(){
        wait.until(presenceOfElementLocated(byMonitorDescription)).click();
    }

    public void clickCompareButton(){
        wait.until(presenceOfElementLocated(byCompareButton)).click();
    }

    public MonitorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static String getMonitorTitle(WebDriver driver) {
        return driver.findElement(By.cssSelector("h1[class='product__title']")).getText();

    }

    public static int getMonitorPrice(WebDriver driver) {
        return Integer.parseInt(driver.findElement(By.cssSelector("p.product-prices__big")).getText()
                .replace("&nbsp", "")
                .replaceAll(" ", "")
                .replace("₴", "")
        );
    }

    public int checkCounter(String counter){
        wait.until(textToBePresentInElementLocated(byCounterCompareList, counter));
        return Integer.parseInt(driver.findElement(byCounterCompareList).getText());
    }

    public void clickComparisonLink(){
        driver.findElement(comparisonButton).click();
        driver.findElement(comparisonModalLink).click();
    }




}
