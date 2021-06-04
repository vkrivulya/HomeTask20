package HW24.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.IntStream;

public class MonitorsListPage extends RozetkaBasePage {

    public MonitorsListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void findElementsByPrice(WebDriver driver, int comparedPrice) {
        List<WebElement> elementsList = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
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
