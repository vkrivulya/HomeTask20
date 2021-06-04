package HW24.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SamsungProductsListPageFactory extends RozetkaBasePageFactory {

    @FindBy(xpath = "//span[contains(., 'Мобильные телефоны')]")
    WebElement mobilePhonesButton;

    public void mobilePhonesButtonClick() {
        wait.until(visibilityOf(mobilePhonesButton)).click();
    }


    public SamsungProductsListPageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
