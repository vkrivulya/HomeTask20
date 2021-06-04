package HW24.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.IntStream;

public class MonitorsListPageFactory extends RozetkaBasePageFactory {

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    List<WebElement> elementsList;

    public MonitorsListPageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public void findElementsByPrice(WebDriver driver, int comparedPrice) {
        IntStream.range(0, elementsList.size())
                .filter(i -> Integer.parseInt(elementsList.get(i).getText().replace(" ", "")) < comparedPrice)
                .findFirst()
                .ifPresent(i ->
                {
                    i++;
                    driver.findElement(By.xpath("(//span[@class='goods-tile__price-value']//preceding::a[2])" + "[" + i + "]")).click();
                });
    }





}
