package HW24.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ComparePageFactory extends RozetkaBasePageFactory {

    @FindBy(css = "div[class='product__prices']")
    protected List<WebElement> priceElementsList;

    public int elementsListIsMatches() {
        wait.until(visibilityOfAllElements(priceElementsList));
        return priceElementsList.size();
    }

    public ComparePageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
