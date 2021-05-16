
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.*;

public class Task1Test2 {

    Task1 task1 = new Task1();

    String[] expected = {"Mango", "Apple", "Banana"};

    String[] actual = {"Mango", "Apple", "Banan"};

    List<String> list1 = Arrays.asList("1", "2", "3", "4");
    List<String> list2 = Arrays.asList("1", "2", "3", "4");
    List<String> list3 = Arrays.asList("1", "2", "4", "3");

//
//    @Test
//    public void arrayEquals() {
////        Assert.assertArrayEquals(expected, actual);
//    }

    @Test
    public void whenTestingForEquality_ShouldBeEqual() throws Exception {
        Assert.assertEquals(list1, list2);
        Assert.assertNotSame(list1, list2);
        Assert.assertNotEquals(list1, list3);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1/0;
    }

    @Test(enabled=false)
    public void divisionWithException2() {
        System.out.println("Method is not ready yet");
    }

    @Test(groups="method1")
    public void testingMethod1() {
        System.out.println("Method - testingMethod1()");
    }

    @Test(groups="method2")
    public void testingMethod2() {
        System.out.println("Method - testingMethod2()");
    }

    @Test(groups="method1")
    public void testingMethod1_1() {
        System.out.println("Method - testingMethod1_1()");
    }

//    @Test
//    @Parameters(value="number")
//    public void parameterIntTest(@Optional(1) int number) {
//        System.out.println("Parameterized Number is : " + number);
//    }

    @Test
    public void testAssertTrue()
    {
        Assert.assertTrue( 2 > 1 );
        System.out.println("compare 2 is greated than 1");

    }

    @Test
    public void testAssertFalse()
    {
        System.out.println("compared two not equal string");
        Assert.assertFalse( "chercher tech".equals("karthiQ") );

    }

    @Test
    public void testFail()
    {
        Assert.fail("test purpose", new NoSuchFrameException("user thrown exception"));
    }



}
