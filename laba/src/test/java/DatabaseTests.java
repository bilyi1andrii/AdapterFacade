import org.junit.Test;

import com.example.database.AuthorizationAdapter;
import com.example.database.DataBaseAdapter;
import com.example.database.ReportBuilder;
import com.example.database.Авторизація;
import com.example.database.БазаДаних;

import org.junit.Assert;

public class DatabaseTests {

    private static final String EXPECTED_USER_DATA = "hello";
    private static final String EXPECTED_STATIC_DATA = "hello2";

    @Test
    public void testDataBaseAdapter() {
        БазаДаних dataBase = new БазаДаних();
        DataBaseAdapter adapter = new DataBaseAdapter(dataBase);

        Assert.assertEquals("User data should match",
                EXPECTED_USER_DATA, adapter.getUserData());
        Assert.assertEquals("Static data should match",
                EXPECTED_STATIC_DATA, adapter.getStaticData());
    }

    @Test
    public void testAuthorizationAdapter() {
        БазаДаних dataBase = new БазаДаних();
        Авторизація authorization = new Авторизація();
        AuthorizationAdapter adapter = new AuthorizationAdapter(authorization);

        boolean result = adapter.authorize(dataBase);
        Assert.assertTrue("Authorization should be successful", result);
    }

    @Test
    public void testReportBuilder() {
        БазаДаних dataBase = new БазаДаних();
        DataBaseAdapter adapter = new DataBaseAdapter(dataBase);
        ReportBuilder reportBuilder = new ReportBuilder(adapter);

        java.io.ByteArrayOutputStream outContent =
        new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outContent));

        reportBuilder.buildReport();

        System.setOut(originalOut);

        String expectedOutput = "User Data: "
        + EXPECTED_USER_DATA + System.lineSeparator()
        + "Static Data: " + EXPECTED_STATIC_DATA
        + System.lineSeparator();

        Assert.assertEquals("Report output should match",
                expectedOutput, outContent.toString());
    }
}
