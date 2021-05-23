package HW21;

import org.testng.annotations.DataProvider;

public class DataProviderNew {

    private static final String LOGIN = "1303";
    private static final String PASSWORD = "Guru99";
    private static final String INVALIDDATA = "qwerty";
    private static final String EMPTYINPUTTEXT = "";


    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {LOGIN, INVALIDDATA},
                {INVALIDDATA, PASSWORD},
                {INVALIDDATA, INVALIDDATA},
                {EMPTYINPUTTEXT, PASSWORD},
                {EMPTYINPUTTEXT, EMPTYINPUTTEXT},
                {LOGIN, LOGIN},
                {PASSWORD, PASSWORD}

        };
    }

}