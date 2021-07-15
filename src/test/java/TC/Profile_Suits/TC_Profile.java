package TC.Profile_Suits;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Profile {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProfilePage profilePage;


    @BeforeClass
    public void beforeclass(){
         driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online/");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        profilePage=new ProfilePage(driver);


    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("User Can Change the info ")
    @Link("https://trello.com/c/S9mhJCOf/1122-automation")
    public void change_user_data_successfully(){
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.navigate_To_Profile_Page();
        profilePage.change_User_info("Mostafa Ali","Mostafa.ali@88.com");
        homePage.User_LogOut();

    }
    @Test(dependsOnMethods = "User_Can_Leave_Email_field_without_value")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that tha name is changed sucessfully!")
    public void Verify_name_isChanged(){
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.navigate_To_Profile_Page();
        Assertions.assertEquals("Mostafa Ali",profilePage.getName());


    }
    @Test(dependsOnMethods = "Verify_name_isChanged")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Change account type!")
    public void User_change_AccountType(){

        profilePage.navigat_To_Profile_Page();
        homePage.navigate_To_Profile_Page();
        profilePage.change_account_type();
        Assertions.assertEquals("تم تحديث الملف الشخصي بنجاح!",profilePage.error_message());
        homePage.User_LogOut();
    }
    @Test(dependsOnMethods = "change_user_data_successfully")
    @Severity(SeverityLevel.BLOCKER)
    @Description("User Can Change the info ")
    public void User_Can_Leave_Email_field_without_value(){
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.navigate_To_Profile_Page();
        profilePage.change_User_info("Mostafa Ali"," ");
        Assertions.assertEquals("تم تحديث الملف الشخصي بنجاح!",profilePage.error_message());
        homePage.User_LogOut();




}
}


