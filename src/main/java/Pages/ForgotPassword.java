package Pages;

import com.shaft.gui.element.ElementActions;
import io.appium.java_client.internal.ElementMap;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    //constructor
    private WebDriver driver;
    public ForgotPassword(WebDriver driver){
        this.driver=driver;
    }
    //Element
    private By forgotLink=By.xpath("//a[contains(text(),'نسيت كلمة المرور؟')]");
    private By phone =By.xpath("//div[@id='register-phoneNumber']//input[@placeholder='ادخل رقم الجوال']");
    private By next1 =By.xpath("//button[@class='btn wizard-footer-right btn-primary']");
    private By code1 =By.xpath("//div[@id='vie-otp-input-wrap']//div//div[1]//input[1]");
    private By code2 =By.xpath("//div[@id='vie-otp-input-wrap']//div//div[2]//input[1]");
    private By code3 =By.xpath("//div[@id='vie-otp-input-wrap']//div//div[3]//input[1]");
    private By code4 =By.xpath("//div[@id='vie-otp-input-wrap']//div//div[4]//input[1]");
    private By pass =By.xpath("//input[@id='password1']");
    private By save=By.xpath("//button[@class='btn wizard-footer-right finish-button btn-primary']");
    private By ValidMessage=By.xpath("//div[@class='toasted toasted-primary success']");
    private By errorMessaga=By.xpath("//div[@class='toasted toasted-primary error']");



    //Actions
    public void Forgot_Password(String PhoneNumber,String cod1,String cod2,String cod3,String cod4,String password){

        ElementActions.click(driver,forgotLink);
        ElementActions.type(driver,phone,PhoneNumber);
        ElementActions.click(driver,next1);
        ElementActions.type(driver,code1,cod1);
        ElementActions.type(driver,code2,cod2);
        ElementActions.type(driver,code3,cod3);
        ElementActions.type(driver,code4,cod4);
        ElementActions.type(driver,pass,password);
        ElementActions.click(driver,save);

    }
    public void forgotPasswordUsinginVailData(String PhoneNumber){
        ElementActions.click(driver,forgotLink);
        ElementActions.type(driver,phone,PhoneNumber);
        ElementActions.click(driver,next1);

    }
    public String validationMessage(){
        return ElementActions.getText(driver,ValidMessage);
    }
    public String Error_Message(){
        return ElementActions.getText(driver,errorMessaga);
    }
}
