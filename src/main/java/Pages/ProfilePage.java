package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;
    //constructor
    public ProfilePage(WebDriver driver){
        this.driver=driver; }
        //Element Loctors
    private By name=By.xpath("//div[@class='col-md-12 my-profile my-account mb-5']//div//input[@class='form-control'and@type='text'][1]");
    private By email=By.xpath("//body//div//input[2][@class='form-control']");
    private By saveBtton=By.xpath("//button[@class='btn button mt-5 mb-2 btn-primary']");
    private By drobdown=By.xpath("//div[@class='multiselect__tags']//span[@class='multiselect__single']");
    private By selectAccouttype=By.xpath("//li[@class='multiselect__element'][4]");
    private By profileicon = By.xpath("//span[@class='hi-user icon']");
    private By profilepage = By.xpath("//ul[@class='dropdown-menu show']//a[@role='menuitem'][contains(text(),'الملف الشخصي')]");
    private By errorMessage=By.xpath("//div[@class='toasted toasted-primary error']");


    //Actions
    public void change_User_info(String Name,String Email){

        ElementActions.type(driver,name,Name);
        ElementActions.type(driver,email,Email);
        ElementActions.click(driver,saveBtton);
    }

    public void change_account_type(){
        ElementActions.click(driver,drobdown);
        ElementActions.click(driver,selectAccouttype);
        ElementActions.click(driver,saveBtton);
    }
    public void navigat_To_Profile_Page(){
        ElementActions.click(driver,profileicon);
        ElementActions.click(driver,profilepage);
    }
    public String getName(){
        return ElementActions.getText(driver,name);
    }
    public String error_message(){
        return ElementActions.getText(driver,errorMessage);
    }


}
