package Pages;

import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    //constructor
    public SearchPage(WebDriver driver){
        this.driver=driver;

    }
    //Element
    private By locationField=By.id("autosuggest__input_home");
    private By selectResult=By.xpath("//div[@class='pac-item'][1]");
    private By searchBtn=By.xpath("//button[@class='btn w-100 btn-primary']");
    private By realEtstetype=By.xpath("//button[@class='btn dropdown-toggle btn--white btn--shadow ']");
    private By selectType=By.xpath("//fieldset[@class='form-group m-0']//div//div//div[2]");
    private By chooseagent=By.xpath("//label[contains(text(),'جهات عقاريه')]");
    private By agent=By.xpath("//div[@class='p-24']//h5[@class='mb-md-3'][contains(text(),'Mohammed')]");
    private By assertresnt=By.xpath("//label[@class='btn btn-light active']//input[@value='600ea6ade3672a38437e635d']");
    private By clickSale=By.xpath("//ul[@id='responsive']//li[3]");
    private By logo=By.xpath("//div[@id='logo']");
    private By clcikrent=By.xpath("//ul[@id='responsive']//li[2]");
    private By realEstaten=By.xpath("//div[starts-with(@class,'listings-container grid-layout')]/div[1]");


    //Actions
    public void User_Search(String city){
        ElementActions.click(driver,chooseagent);
        ElementActions.type(driver,locationField,city);
        ElementActions.click(driver,selectResult);
        ElementActions.click(driver,searchBtn);
        ElementActions.click(driver,agent);

    }
    public void quickSearch(){
        ElementActions.click(driver,clickSale);
        ElementActions.click(driver,realEstaten);


    }
    public void quickSearchForRent(){
        ElementActions.click(driver,logo);
        ElementActions.click(driver,clcikrent);
    }





}
