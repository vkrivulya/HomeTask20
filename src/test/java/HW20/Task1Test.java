//package HW20;
//
//import HW20.DataProviderNew;
//import org.testng.annotations.*;
//
//public class Task1Test {
//
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("Before class");
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("Before method");
//    }
//
//    @Test(dataProvider = "data-provider", dataProviderClass = DataProviderNew.class)
//    public void instanceDataProvider(String key, String value) {
//        System.out.println("instance DataProvider\n" + key + ": " + value);
//    }
//
//    @Test
//    public void method1() {
//        System.out.println("This is method 1");
//    }
//
//    @Test(dependsOnMethods = {"method1"})
//    public void method2() {
//        System.out.println("This is method 2");
//    }
//
//    @Test(timeOut = 10)
//    public void timeOut() {
//        System.out.println("This is method with timeout");
//    }
//    @Test(timeOut=200)
//    public void timeOut2() throws InterruptedException
//    {
//        Thread.sleep(500);
//        System.out.println("This is testcase1");
//    }
//
//
//    @Test(description = "This is testcase")
//    public void testcase() {
//        System.out.println("HR");
//    }
//
//    @Test(dependsOnMethods = {"testcase3", "testcase2"})
//    public void testcase1() {
//        System.out.println("This is test case1");
//    }
//
//    @Test
//    public void testcase2() {
//        System.out.println("This is test case2");
//    }
//
//    @Test
//    public void testcase3() {
//        System.out.println("This is test case3");
//    }
//
//    @Test(priority = 2)
//    public void apple() {
//        System.out.println("I am Apple");
//    }
//
//    @Test(priority = 1)
//    public void watermelon() {
//        System.out.println("I am Watermelon");
//    }
//
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("after method");
//    }
//
//    @AfterClass
//    public void afterClass(){
//        System.out.println("After class");
//    }
//
//
//}
