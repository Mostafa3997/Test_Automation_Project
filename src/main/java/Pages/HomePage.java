package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Element Locator
    private By login_registerPage = By.xpath("//a[@class='sign-in ml-3 font-weight-bold']");
    private By helpcenter = By.xpath("//ul[@class='nav d-flex   align-items-center justify-content-start']//li[2]");
    private By profileicon = By.xpath("//span[@class='hi-user icon']");
    private By profilepage = By.xpath("//ul[@class='dropdown-menu show']//a[@role='menuitem'][contains(text(),'الملف الشخصي')]");
    private By logout = By.xpath("//ul[@class='dropdown-menu show']//a[@role='menuitem'][contains(text(),'تسجيل الخروج')]");
    private By changePassworDdrobDown = By.xpath("//ul[@class='dropdown-menu show']//a[@role='menuitem'][contains(text(),'تغيير كلمة المرور')]");
    private By registerPage = By.xpath("//ul[@class='nav nav-tabs justify-content-center tabs-nav']//li//a[@class='nav-link']");
    private By AddRealestateBtn = By.xpath("//button[@class='btn button primary background header-add-property-btn m-0 btn-primary']");
    private By logo = By.xpath("//div[@id='logo']");


    //Action
    public void navigateToSignIn() {

        ElementActions.click(driver, login_registerPage);
    }

    public void navigateToHelpCenter() {

        ElementActions.click(driver, helpcenter);
    }

    public void navigate_To_Profile_Page() {
        ElementActions.click(driver, profileicon);
        ElementActions.click(driver, profilepage);
    }

    public void User_LogOut() {
        ElementActions.click(driver, profileicon);
        ElementActions.click(driver, logout);
    }

    public void navigate_To_changePass_Page() {
        ElementActions.click(driver, profileicon);
        ElementActions.click(driver, changePassworDdrobDown);

    }
    public void PressIcon_and_LogOut(){

        ElementActions.click(driver, logout);
    }

    public void navigate_to_SignUp() {
        ElementActions.click(driver, registerPage);
    }

    public void navigate_To_AddRealEstate() {
        ElementActions.click(driver, AddRealestateBtn);
    }





}








