package HW24.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MobilePhonesListPageFactory extends RozetkaBasePageFactory {

    @FindBy(xpath = "//label[contains(., 'Apple')]")
    WebElement appleCheckbox;
    @FindBy(xpath = "//label[contains(., 'Huawei')]")
    WebElement huaweiCheckbox;
    @FindBy(css = "span[class='goods-tile__title']")
    List<WebElement> titleProduct;
    @FindBy(css = "span.goods-title__price-value")
    List<WebElement> priceProduct;
    @FindBy(css = "input[formcontrolname='min']")
    WebElement minPrice;
    @FindBy(css = "input[formcontrolname='max']")
    WebElement maxPrice;
    @FindBy(css = "button[class*='button_color_gray']")
    WebElement submitButton;
    @FindBy(xpath = "//label[contains(., '128 ГБ')]")
    WebElement memoryCheckbox128Gb;

    public void selectManufacturer() {
        wait.until(visibilityOf(appleCheckbox)).click();
        wait.until(visibilityOf(huaweiCheckbox)).click();
    }


    public MobilePhonesListPageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductsListByName() {
        for (WebElement element : titleProduct) {
            if (element.getText().contains("Samsung") || element.getText().contains("Apple") || element.getText().contains("Huawei")) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyProductsListByPrice() {
        for (WebElement e : priceProduct) {
            int goodPrice = Integer.parseInt(e.getText().replace("&nbsp;", "").replaceAll(" ", ""));
            if (goodPrice > 5000 && goodPrice < 15000) {
                return true;
            }
        }
        return false;
    }

    public void setPrice() {
        wait.until(visibilityOf(minPrice)).clear();
        wait.until(visibilityOf(minPrice)).sendKeys("5000");
        wait.until(visibilityOf(maxPrice)).clear();
        wait.until(visibilityOf(maxPrice)).sendKeys("15000");
    }

    public void clickOnSubmitButton() {
        wait.until(visibilityOf(submitButton)).click();
    }


    public void setMemoryToFilter() {
        wait.until(visibilityOf(memoryCheckbox128Gb)).click();
    }

    public boolean verifyProductsListByMemory() {
        for(WebElement e: titleProduct){
            if(e.getText().contains("128GB")){
                return true;
            }
        }
        return false;
    }
}
