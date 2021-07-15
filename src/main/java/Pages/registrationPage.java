package Pages;

import com.shaft.gui.element.ElementActions;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registrationPage {
    private WebDriver driver;
    //constructor
    public registrationPage(WebDriver driver){
        this.driver=driver;
    }
    //Element Loctors
    private By phoneFiled=By.xpath("//div[@id='register-phoneNumber']//input[@placeholder='ادخل رقم الجوال']");
    private By next1=By.xpath("//button[@class='btn wizard-footer-right btn-primary']");
    private By otp1=By.xpath("//div[@id='vie-otp-input-wrap']//div//div[1]//input[1]");
    private By otp2=By.xpath("//div[@id='vie-otp-input-wrap']//div//div[2]//input[1]");
    private By otp3=By.xpath("//div[@id='vie-otp-input-wrap']//div//div[3]//input[1]");
    private By otp4=By.xpath("//div[@id='vie-otp-input-wrap']//div//div[4]//input[1]");
    private By name=By.xpath("//input[@placeholder='ادخل اسمك هنا']");
    private By email =By.xpath("//input[@placeholder='ادخل بريدك الإلكتروني']");
    private By pass=By.id("password register-password");
    private By drobDown =By.xpath("//div[@class='multiselect__select']");
    private By selectaccounttype=By.xpath("//li[@class='multiselect__element'][4]");
    private By registerbtn=By.xpath("//button[@class='btn wizard-footer-right finish-button btn-primary']");
    private By profileicon= By.xpath("//span[@class='hi-user icon']");
    private By welcommessage=By.xpath("//ul[@class='dropdown-menu show']//li[@role='presentation']//p[@class='b-dropdown-text']//span//span[@class='text'][contains(text(),'مرحبا Mostafa Ali')]");
    private By errorMessage=By.xpath("//div[@class='toasted toasted-primary error']");
    private By logo=By.xpath("//div[@id='logo']");
    private By acceptPolicy=By.xpath("//div[@class='wizard-tab-content']//label//input[@id='rememberme']");


    public void Fill_registration_form(String PhoneNumber,String code1  , String code2 ,String code3 ,String code4 ,String Name ,String Email ,String password ){
        ElementActions.type(driver,phoneFiled,PhoneNumber);
        ElementActions.type(driver,pass,password);
        ElementActions.click(driver,acceptPolicy);
        ElementActions.click(driver,next1);
        ElementActions.type(driver,otp1,code1);
        ElementActions.type(driver,otp2,code2);
        ElementActions.type(driver,otp3,code3);
        ElementActions.type(driver,otp4,code4);
        ElementActions.type(driver,name,Name);
        ElementActions.type(driver,email,Email);
        ElementActions.click(driver,drobDown);
        ElementActions.click(driver,selectaccounttype);
        ElementActions.click(driver,registerbtn);
        ElementActions.click(driver,profileicon);
    }
    public void register_with_phone_exist(String PhoneNumber){
        ElementActions.type(driver,phoneFiled,PhoneNumber);
        ElementActions.click(driver,acceptPolicy);

        ElementActions.click(driver,next1);

    }
    public String error_message(){
        return ElementActions.getText(driver,errorMessage);
    }
    public String assertName(){
        return ElementActions.getText(driver,welcommessage);

    }
    public void PressLogo_andNavigatto_SignIn(){
        ElementActions.click(driver,logo);
    }
    public void user_cannot_register_without_phonenumber( String PhoneNumber){
        ElementActions.type(driver,phoneFiled,PhoneNumber);
        ElementActions.click(driver,acceptPolicy);

        ElementActions.click(driver,next1);
    }
    public String errorMessage_telling_enter_phoneFirst(){
        return ElementActions.getText(driver,errorMessage);
    }






}
