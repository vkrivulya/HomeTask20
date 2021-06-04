package HW24.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamsungProductsListPage extends RozetkaBasePage {

    By mobilePhonesButton = By.xpath("//span[contains(., 'Мобильные телефоны')]");

    public void mobilePhonesButtonClick(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhonesButton)).click();
    }


    public SamsungProductsListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
