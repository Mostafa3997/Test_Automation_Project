package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    //constructor
    public LoginPage(WebDriver driver){ this.driver= driver; }
    //Element Locator
    private By login_registerPage = By.xpath("//a[@class='sign-in ml-3 font-weight-bold']");
    private By PhoneNumberField =By.xpath("//div[@id='login-phoneNumber']//input[@placeholder='ادخل رقم الجوال']");
    private By passwordField=By.id("password login-password");
    private By loginButton =By.xpath("//button[@class='btn button margin-bottom-0 btn-primary']");
    private By errorMessaga=By.xpath("//div[@class='toasted toasted-primary error']");
    private By logo=By.xpath("//div[@id='logo']");

    //Actions
    public void FillLogin_Form(String PhoneNumber , String password) {
        ElementActions.type(driver, PhoneNumberField, PhoneNumber);
        ElementActions.type(driver, passwordField, password);
        ElementActions.click(driver, loginButton);
    }
    public String Error_Messga(){
        return ElementActions.getText(driver,errorMessaga);
    }
    public void Login_with_Leaving_field_empty(){
        ElementActions.click(driver,logo);
        ElementActions.click(driver,login_registerPage);
        ElementActions.click(driver,loginButton);
    }

}