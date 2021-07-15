package Pages;

import com.shaft.gui.element.ElementActions;
import org.apache.xalan.templates.ElemApplyImport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search_For_Agent {
    WebDriver driver;
    //constructor
    public Search_For_Agent(WebDriver driver){
        this.driver=driver;
    }
    //Element
    private By agent=By.xpath("//label[contains(.,' جهات عقاريه')]");
    private By SearchField=By.xpath("//input[@id='autosuggest__input_home']");
    private By selectresult=By.xpath("//div[@class='pac-item'][1]");
    private By SerBTn=By.xpath("//button[@class='btn w-100 btn-primary']");
    private By selectAgent=By.xpath("//h5[contains(.,'شركة الخيرات للعقارات')]");
    private By logo = By.xpath("//div[@id='logo']");
    private By property=By.xpath("//div[starts-with(@class,'listings-container grid-layout')]/div[1]");
    private By asserName=By.xpath("//a[contains(.,'شركة الخيرات للعقارات')]");



    //Actions
    public void User_Search_For_Agent(String location){
        ElementActions.click(driver,agent);
        ElementActions.type(driver,SearchField,location);
        ElementActions.click(driver,selectresult);
        ElementActions.click(driver,SerBTn);
        ElementActions.click(driver,selectAgent);
        ElementActions.click(driver,property);


    }
    public void clickLogo(){
        ElementActions.click(driver,logo);
    }
    public String getname(){
        return ElementActions.getText(driver,asserName);
    }


}
