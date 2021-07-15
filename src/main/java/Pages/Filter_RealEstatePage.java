package Pages;

import com.helger.commons.changelog.EChangeLogAction;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Filter_RealEstatePage {

    WebDriver driver;
    public Filter_RealEstatePage(WebDriver driver){
        this.driver=driver;

    }
    //Element
    private By clickFilter=By.xpath("//button[@class='btn dropdown-toggle btn--white btn--shadow ']");
    private By choosetype= By.xpath("(//div[starts-with(@class,'bv-no-focus-ring')and@id='type']/div[2])");

    public void Filter(){
        ElementActions.click(driver,clickFilter);
      //  ElementActions.click(driver,choosetype);
    }

}
