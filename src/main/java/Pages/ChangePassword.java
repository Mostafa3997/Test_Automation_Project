package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword {
    private WebDriver driver;
    //constructor
    public ChangePassword(WebDriver driver){
        this.driver=driver;

    }
    //Element Loctors
    private By currentPasswordField=By.id("prevPassword");
    private By NewPasswordFiled=By.id("password");
    private By changepasswordButton=By.xpath("//button[@class='btn button mt-5 mb-2 btn-primary']");

    //Actions
    public void ChangePass(String currentPass ,String NewPass){
        ElementActions.type(driver,currentPasswordField,currentPass);
        ElementActions.type(driver,NewPasswordFiled,NewPass);
        ElementActions.click(driver,changepasswordButton);

    }

}
