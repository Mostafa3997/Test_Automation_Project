package TC.ChangePassword;

import Pages.ChangePassword;
import Pages.HomePage;
import Pages.LoginPage;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_ChangePassword_GUI {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ChangePassword changePassword;

    @BeforeClass
    public void beforeclass(){
         driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online/");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        changePassword=new ChangePassword(driver);

}
    @Test
    public void User_Can_changePassword_successfully(){
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.navigate_To_changePass_Page();
        changePassword.ChangePass("123456","123456");
        homePage.User_LogOut();
    }
    @Test(dependsOnMethods ="User_Can_changePassword_successfully" )
    public void Verify_thePassword_isChanged(){

        loginPage.FillLogin_Form("0500000000","123456");

    }





    @AfterClass
    public void AfterCalss(){
        driver.quit();
    }

}
