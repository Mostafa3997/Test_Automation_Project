package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFavorite {
    private WebDriver driver;
    public MyFavorite(WebDriver driver){
        this.driver=driver;
    }
    //Element
    private By profileicon = By.xpath("//span[@class='hi-user icon']");
    private By myfavorite = By.xpath("//ul[@class='dropdown-menu show']//a[@role='menuitem'][contains(text(),'مفضلتي')]");



    //Actions
    public void DeleteRealEstatFromFavorite(){
        ElementActions.click(driver,profileicon);
        ElementActions.click(driver,myfavorite);

    }

}
