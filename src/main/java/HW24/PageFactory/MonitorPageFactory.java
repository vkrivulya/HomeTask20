package HW24.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MonitorPageFactory extends RozetkaBasePageFactory {

    @FindBy(xpath = "//li[contains(., ' Все о товаре ')]")
    WebElement byMonitorDescription;
    @FindBy(xpath = "//button[@class='compare-button ng-star-inserted']")
    WebElement byCompareButton;
    @FindBy(xpath = "//rz-icon-counter//child::span")
    WebElement byCounterCompareList;
    @FindBy(css = "li[class='header-action__item header-action__item--comparison'] button")
    WebElement comparisonButton;
    @FindBy(css = "a.comparison-modal__link")
    WebElement comparisonModalLink;


    public void clickMonitorDescription(){
        wait.until(visibilityOf(byMonitorDescription)).click();
    }

    public void clickCompareButton(){
        wait.until(visibilityOf(byCompareButton)).click();
    }

    public MonitorPageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
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
        wait.until(visibilityOf(byCounterCompareList));
        return Integer.parseInt(byCounterCompareList.getText());
    }

    public void clickComparisonLink(){
        comparisonButton.click();
        comparisonModalLink.click();
    }




}
