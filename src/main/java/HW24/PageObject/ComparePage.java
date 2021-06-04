package HW24.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ComparePage extends RozetkaBasePage {

    By byProductPrices = By.cssSelector("div[class='product__prices']");

    public int elementsListIsMatches() {
        wait.until(presenceOfElementLocated(byProductPrices));
        List<WebElement> priceElementsList = driver.findElements(byProductPrices);
        return priceElementsList.size();
    }

//

    public ComparePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
