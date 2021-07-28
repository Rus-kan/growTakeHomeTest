package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.util.List;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[contains(@class, 'metricMenu---expandMetric')]")
    public WebElement expandMetricBtn;

    @FindBy(xpath = "//div[contains(@class, 'STATIC-dashboard-metric-dragResize')]")
    public WebElement metrics;

    @FindBy(xpath = "//div[contains(text(), 'Add New')]")
    public WebElement addNewBtn;

    @FindBy(xpath = "//div[contains(@class,'metricTile---titleBar')]")
    public WebElement hoverOver;

    @FindBy(xpath = "//h1[contains(text(), 'Dashboard for Sales Team')]")
    public WebElement dashName;

    @FindBy(xpath = "//div[contains(@class, 'avatar---initials')]")
    public WebElement acctBtn;

    @FindBy(xpath = "//div[contains(text(), 'Log Out')]")
    public WebElement logoutBtn;

    @FindBy(xpath = "//div[contains(@class, 'expandedMetric---contentArea')]")
    public WebElement expendMetricWindow;

    @FindBy(xpath = "//div[contains(@class, 'closeButton')]")
    public WebElement closeExpandView;

    @FindBy(xpath = "//div[contains(@class, 'toggleMenuIcon')]")
    public WebElement dashboardNavigation;

    @FindBy(xpath = "//input[contains(@class, 'searchInput')]")
    public WebElement searchInput;

    @FindBy(xpath = "//span[contains(@class, 'dashboardName')]")
    public List<WebElement> dashboardsList;

    public void logOut() {
        acctBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }

    public Boolean expandViewIsPresented() {
        return expendMetricWindow.isDisplayed();
    }

    public Boolean metricsArePresented() {
        return metrics.isDisplayed() && dashName.isDisplayed();
    }

    public void exitExpandView() {
        closeExpandView.click();
    }

    public boolean dashboardsMissing() {
        return dashboardsList.isEmpty();
    }
    public boolean dashboardsPresented(){
        Boolean flag = true;
        for(WebElement dashboard: dashboardsList){
            if(!dashboard.isDisplayed()){
                flag=false;
            }
        }
        return flag;
    }
}