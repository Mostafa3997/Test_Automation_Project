package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpCenter {
    private WebDriver driver;
    //constructor
    public HelpCenter(WebDriver driver){
        this.driver=driver; }
        //Element Locator
    private By selecttype=By.xpath("//form//div//div[@class='multiselect__select']");
    private By suggesttype=By.xpath("//span[@class='multiselect__option multiselect__option--highlight']");
    private By typeTopic=By.id("subject");
    private By typeMessage =By.id("comments");
    private By problemtype=By.xpath("//ul[@class='multiselect__content']//li[2]");
    private By messagetype=By.xpath("//ul[@class='multiselect__content']//li[3]");
    private By submitButton =By.xpath("//button[@id='submit']");

      //Actions
    public void Send_suggestion_HelpCenter(String topic,String Message){
        ElementActions.click(driver,selecttype);
        ElementActions.click(driver,suggesttype);
        ElementActions.type(driver,typeTopic,topic);
        ElementActions.type(driver,typeMessage,Message);
        ElementActions.click(driver,submitButton);
    }
    public void Send_Problem__To_HelpCenter(String topic,String Message){
        ElementActions.click(driver,selecttype);
        ElementActions.click(driver,problemtype);
        ElementActions.type(driver,typeTopic,topic);
        ElementActions.type(driver,typeMessage,Message);
        ElementActions.click(driver,submitButton);

    }
    public void Send_message__To_HelpCenter(String topic,String Message){
        ElementActions.click(driver,selecttype);
        ElementActions.click(driver,messagetype);
        ElementActions.type(driver,typeTopic,topic);
        ElementActions.type(driver,typeMessage,Message);
        ElementActions.click(driver,submitButton);

    }






}
