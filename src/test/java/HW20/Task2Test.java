package HW20;

import HW20.PropertiesReaderClassLoader;
import org.testng.annotations.Test;

public class Task2Test {

    @Test
    public void test2() {
        String baseUrl = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "baseUrl");
        String userNameValue = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "userName");
        String userEmailValue = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "userEmail");
        String userPhoneValue = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "userPhone");
        System.out.println("baseUrl = " + baseUrl);
        System.out.println("userNameValue = " + userNameValue);
        System.out.println("userEmailValue = " + userEmailValue);
        System.out.println("userPhoneValue = " + userPhoneValue);
    }
}
