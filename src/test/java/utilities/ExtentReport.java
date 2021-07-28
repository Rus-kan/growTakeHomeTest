package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

    private static ExtentHtmlReporter configs;
    private static ExtentReports reports;
    private static ExtentTest extentTest;

    static{
        configs = new ExtentHtmlReporter("./extentReport/report.html");
        configs.config().setTheme(Theme.DARK);
        configs.config().setDocumentTitle("Grow Test Exercise");
        reports = new ExtentReports();
        reports.attachReporter(configs);
        reports.setSystemInfo("username:", "Ruslan_Kanatbek");
        reports.setSystemInfo("environment:", "random");
    }

    public static void startTest(String testName){
        extentTest = reports.createTest(testName);
    }

    public static void pass(){
        extentTest.pass("PASS");
    }

    public static void fail()  {
        extentTest.fail("FAILED");

    }

    public static void endReport(){
        reports.flush();
    }

}
