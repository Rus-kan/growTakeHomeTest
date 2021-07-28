package testCases;

import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.Log;


public class TestDashboard{
    DashboardPage dash = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void setup(TestInfo info){
        Log.info("Starting point for test");
        ExtentReport.startTest(info.getDisplayName());
        Driver.getDriver().get(Config.getProperty("growUrl"));
        Assertions.assertEquals(Driver.getDriver().getTitle(), Config.getProperty("title"));
        loginPage.sighIn(Config.getProperty("emailId"), Config.getProperty("password"));
    }

    @AfterEach
    public void tearDown(TestInfo info){
        dash.logOut();
        Assertions.assertEquals(Driver.getDriver().getTitle(), Config.getProperty("title"));
        Log.info("End of "+info.getDisplayName());
        ExtentReport.endReport();
        Driver.quitDriver();
    }


    @Test
    @DisplayName("Expand Metric")
    public void testExpandMetric(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(dash.hoverOver).build().perform();
        dash.expandMetricBtn.click();
        Assertions.assertTrue(dash.expandViewIsPresented(), "expand view didn't triggered");
        dash.exitExpandView();
        Assertions.assertTrue(dash.metricsArePresented(), "No metrics on the page");
    }

    @Test
    @DisplayName("Search Dashboards")
    public void searchDashboard(){
        dash.dashboardNavigation.click();
        dash.searchInput.sendKeys(Config.getProperty("searchQuery"));
        Assertions.assertTrue(dash.dashboardsMissing());
        dash.searchInput.clear();
        Assertions.assertTrue(dash.dashboardsPresented());
    }
}
