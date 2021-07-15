package Pages;

import com.shaft.gui.element.ElementActions;
import org.apache.xalan.templates.ElemApplyImport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class My_RealEstate {
    private WebDriver driver;
    public My_RealEstate(WebDriver driver){
        this.driver=driver;
    }
    //Element
    private By profileicon = By.xpath("//span[@class='hi-user icon']");
    private By myrealEstat = By.xpath("//ul[@class='dropdown-menu show']//a[@role='menuitem'][contains(text(),'عقاراتي')]");


    //ِActions
    public void DeleteRealEstate(){
        ElementActions.click(driver,profileicon);
        ElementActions.click(driver,myrealEstat);

    }

}
