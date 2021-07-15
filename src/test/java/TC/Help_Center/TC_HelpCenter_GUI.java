package TC.Help_Center;

import Pages.HelpCenter;
import Pages.HomePage;
import Pages.LoginPage;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_HelpCenter_GUI {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private HelpCenter helpCenter;
    @BeforeClass
    public void berforeClass (){
        driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        helpCenter=new HelpCenter(driver);

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Send Suggestion to the admin")
    public void Send_Your_Suggestion(){
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.navigateToHelpCenter();
        helpCenter.Send_suggestion_HelpCenter("I suggest to Make chat bot","I suggest to Make chat bot to respond quick! ");
    }
    @Test(dependsOnMethods = "Send_Your_Suggestion")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Send Problem to the admin")
    public void Send_Your_Problem(){
        homePage.navigateToHelpCenter();
        helpCenter.Send_Problem__To_HelpCenter("I'm facing problem","please solve it as soo as possible!");
    }
    @Test(dependsOnMethods = "Send_Your_Problem")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Send Message to the admin")
    public void Send_Your_Message(){
        homePage.navigateToHelpCenter();
        helpCenter.Send_message__To_HelpCenter("Love Message","I Love the Hectar and so Proud of it ");
    }
    @AfterClass
    public void AfterCalss(){
        driver.quit();
    }
}
