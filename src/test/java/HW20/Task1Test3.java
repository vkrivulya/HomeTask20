package HW20;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Task1Test3 {

    static WebDriver driver ;
    public static void main(String[] args) {
        //check driver is not null
        Assert.assertNotNull(driver);



        Object[] objArray1 =  new Object[3];
        objArray1[0] = 1;
        objArray1[1] = "chercher tech";
        objArray1[2] = false;

        Object[] objArray2 =  new Object[3];
        objArray2[0] = "chercher tech";
        objArray2[1] = false;
        objArray2[2] = 1;
        // compare two arrays
        Assert.assertEqualsNoOrder(objArray1, objArray2);
        System.out.println("Lists compared and AssertionError didnot occur");
    }

}
