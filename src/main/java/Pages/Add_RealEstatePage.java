package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_RealEstatePage {
    private WebDriver driver;
    //constructor
    public Add_RealEstatePage(WebDriver driver){
        this.driver=driver;
    }
    //Element Loctors
    private By type_Flat=By.xpath("//label[contains(.,'ِشقة')]");
    private By type_Villa=By.xpath("//label[contains(.,'فيلا')]");
    private By type_Land=By.xpath("//label[contains(.,'أرض')and@class='custom-control-label'] ");
    private By type_building=By.xpath("//label[contains(.,'عمارة ')]");

    private By State=By.xpath("//label[contains(.,' للايجار ')]");
    private By price=By.id("price");
    private By area=By.id("area");
    private By period=By.xpath("//label[contains(.,'شهري')]");
    private By populationType=By.xpath("//label[contains(.,'عوائل')]");
    private By populationLand=By.xpath("//label[contains(.,'سكني')]");
    private By next1=By.xpath("//button[@class='btn wizard-footer-right btn-primary btn-lg']");
    private By locationField=By.xpath("//input[@class='autosuggest__input form-control pac-target-input']");
    private By selectResult=By.xpath("//div[@class='pac-item'][1]");
    private By next2 =By.xpath("//button[@class='btn wizard-footer-right btn-primary btn-lg']");
    private By age=By.id("age");
    private By floorNumber=By.id("floor");
    private By NuRomes=By.id("numberOfRooms");
    private By NumLivingRome   =By.id("numberOfLivingRoom");
    private By NuBathrome=By.id("numberOfBathRoom");
    private By NumKitchen=By.id("numberOfKitchenUnit");
    private By Feature=By.xpath("//div[@class='checkboxes in-row margin-bottom-20 bv-no-focus-ring']//div[1]");
    private By UploadImage=By.xpath("//input[@id='images']");
    private By next3=By.xpath("//button[@class='btn wizard-footer-right btn-primary btn-lg']");
    private By preview=By.xpath("//button[@class='btn wizard-footer-right btn-primary btn-lg']");
    private By publish =By.xpath("//button[@class='btn wizard-footer-right finish-button btn-primary btn-lg']");
    private By preViewProperty=By.xpath("//div[@class='success-added-btns']//a[1]");
    private By assertlocations=By.xpath("//span[contains(.,'الرياض')]");
    private By edit=By.xpath("//a[@class='btn']");
    String imagepath="C:\\Users\\Mostafa\\Downloads\\Compressed\\properties\\19\\2.jpg";



    //Actions
    public void User_Add_RealEstat_flat(String Price,String Area,String romes,String location){
        ElementActions.click(driver,type_Flat);
        ElementActions.click(driver,State);
        ElementActions.type(driver,price,Price);
        ElementActions.type(driver,area,Area);
        ElementActions.click(driver,period);
        ElementActions.click(driver,populationType);
        ElementActions.click(driver,next1);
        ElementActions.type(driver,locationField,location);
        ElementActions.click(driver,selectResult);
        ElementActions.click(driver,next2);
        ElementActions.type(driver,NuRomes,romes);
        ElementActions.click(driver,next2);
        ElementActions.typeFileLocationForUpload(driver,UploadImage,imagepath);
        ElementActions.click(driver,next3);
        ElementActions.click(driver,preview);
        ElementActions.click(driver,publish);
        ElementActions.click(driver,preViewProperty);




    }
    public void User_Add_RealEstat_Villa(String Price,String Area,String romes,String location){
        ElementActions.click(driver,type_Villa);
        ElementActions.click(driver,State);
        ElementActions.type(driver,price,Price);
        ElementActions.type(driver,area,Area);
        ElementActions.click(driver,period);
        ElementActions.click(driver,next1);
        ElementActions.type(driver,locationField,location);
        ElementActions.click(driver,selectResult);
        ElementActions.click(driver,next2);
        ElementActions.type(driver,NuRomes,romes);
        ElementActions.click(driver,next2);
        ElementActions.typeFileLocationForUpload(driver,UploadImage,imagepath);
        ElementActions.click(driver,next3);
        ElementActions.click(driver,preview);
        ElementActions.click(driver,publish);
        ElementActions.click(driver,preViewProperty);

    }
    public void User_Add_RealEstat_Land(String Price,String Area,String location){
        ElementActions.click(driver,type_Land);
        ElementActions.click(driver,State);
        ElementActions.type(driver,price,Price);
        ElementActions.type(driver,area,Area);
        ElementActions.click(driver,period);
        ElementActions.click(driver,populationLand);
        ElementActions.click(driver,next1);
        ElementActions.type(driver,locationField,location);
        ElementActions.click(driver,selectResult);
        ElementActions.click(driver,next2);
        ElementActions.click(driver,next2);
        ElementActions.typeFileLocationForUpload(driver,UploadImage,imagepath);
        ElementActions.click(driver,next3);
        ElementActions.click(driver,preview);
        ElementActions.click(driver,publish);
        ElementActions.click(driver,preViewProperty);


    }
    public void User_Add_RealEstat_building(String Price,String Area,String romes,String location){
        ElementActions.click(driver,type_building);
        ElementActions.click(driver,State);
        ElementActions.type(driver,price,Price);
        ElementActions.type(driver,area,Area);
        ElementActions.click(driver,period);
        ElementActions.click(driver,populationLand);
        ElementActions.click(driver,next1);
        ElementActions.type(driver,locationField,location);
        ElementActions.click(driver,selectResult);
        ElementActions.click(driver,next2);
        ElementActions.type(driver,NuRomes,romes);
        ElementActions.click(driver,next2);
        ElementActions.typeFileLocationForUpload(driver,UploadImage,imagepath);
        ElementActions.click(driver,next3);
        ElementActions.click(driver,preview);
        ElementActions.click(driver,publish);
        ElementActions.click(driver,preViewProperty);

    }
    public String locationAssertions(){
        return ElementActions.getText(driver,assertlocations);
    }

}
