package phpTravelers;

import org.testng.annotations.DataProvider;

/**
 * Created by Aleksandra on 06.01.18.
 */
public class TestDataProvider {



    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][] {
                { "demo@phptravels.com", "demoadmin" },
                { "admin@phptravels.com", "demoaasfdmin" }};

    }

    @DataProvider (name = "Login")
    public static Object[][] goodCredentials() {

        return new Object[][] {
                { "admin@phptravels.com", "demoadmin" }};

    }

    @DataProvider(name= "Hotels")
            public static Object [][] hotels (){

        return new Object[][]{
                {"31/01/2018","25/03/2018"},
                {"24/03/2018","13/04/2018"}};

            }
}
