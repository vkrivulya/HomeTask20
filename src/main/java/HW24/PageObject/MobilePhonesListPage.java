package HW24.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MobilePhonesListPage extends RozetkaBasePage {

    By appleCheckbox = By.xpath("//label[contains(., 'Apple')]");
    By huaweiCheckbox = By.xpath("//label[contains(., 'Huawei')]");
    By titleProduct = By.cssSelector("span[class='goods-tile__title']");
    By priceProduct = By.cssSelector("span.goods-title__price-value");
    By minPrice = By.cssSelector("input[formcontrolname='min']");
    By maxPrice = By.cssSelector("input[formcontrolname='max']");
    By submitButton = By.cssSelector("button[class*='button_color_gray']");
    By memoryCheckbox128Gb = By.xpath("//label[contains(., '128 ГБ')]");

    public void selectManufacturer() {
        wait.until(presenceOfElementLocated(appleCheckbox)).click();
        wait.until(presenceOfElementLocated(huaweiCheckbox)).click();
    }


    public MobilePhonesListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean verifyProductsListByName() {
        List<WebElement> elementsList = driver.findElements(titleProduct);
        for (WebElement element : elementsList) {
            if (element.getText().contains("Samsung") || element.getText().contains("Apple") || element.getText().contains("Huawei")) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyProductsListByPrice() {
        List<WebElement> elementsList = driver.findElements(priceProduct);
        for (WebElement e : elementsList) {
            int goodPrice = Integer.parseInt(e.getText().replace("&nbsp;", "").replaceAll(" ", ""));
            if (goodPrice > 5000 && goodPrice < 15000) {
                return true;
            }
        }
        return false;
    }

    public void setPrice() {
        wait.until(presenceOfElementLocated(minPrice)).clear();
        wait.until(presenceOfElementLocated(minPrice)).sendKeys("5000");
        wait.until(presenceOfElementLocated(maxPrice)).clear();
        wait.until(presenceOfElementLocated(maxPrice)).sendKeys("15000");
    }

    public void clickOnSubmitButton() {
        wait.until(presenceOfElementLocated(submitButton)).click();
    }


    public void setMemoryToFilter() {
        wait.until(presenceOfElementLocated(memoryCheckbox128Gb)).click();
    }

    public boolean verifyProductsListByMemory() {
        List<WebElement> elementsList = driver.findElements(titleProduct);
        for(WebElement e: elementsList){
            if(e.getText().contains("128GB")){
                return true;
            }
        }
        return false;
    }
}
