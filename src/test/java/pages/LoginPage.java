package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //1- locate the slogan
    @CacheLookup
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement pswdInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    public void sighIn(String emailId, String pswd){
        emailInput.sendKeys(emailId);
        pswdInput.sendKeys(pswd);
        loginBtn.click();
    }
}
