package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateRealEstePage {
    WebDriver driver;
    //constructor
    public UpdateRealEstePage(WebDriver driver){
        this.driver=driver;

    }
    //Element

    private By Editbutton= By.xpath("//a[@class='btn']");
    private By next=By.xpath("//button[@class='btn wizard-footer-right btn-primary btn-lg']");
    private By publish=By.xpath("//button[@class='btn wizard-footer-right finish-button btn-primary btn-lg']");
    private By preViewProperty=By.xpath("//div[@class='success-added-btns']//a[1]");
    private By errorMessaga=By.xpath("//div[@class='toasted toasted-primary error']");


    public void Edit(){

        ElementActions.click(driver,Editbutton);
        ElementActions.click(driver,next);
        ElementActions.click(driver,next);
        ElementActions.click(driver,next);
        ElementActions.click(driver,next);
        ElementActions.click(driver,next);
        ElementActions.click(driver,publish);
        ElementActions.click(driver,preViewProperty);

    }
    public String assertMessage(){
        return ElementActions.getText(driver,errorMessaga);
    }

}
