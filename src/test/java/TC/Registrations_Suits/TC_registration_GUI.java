package TC.Registrations_Suits;

import Pages.HomePage;
import Pages.registrationPage;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_registration_GUI {
    private WebDriver driver;
    private HomePage homePage;
    private registrationPage registrationPage;

    @BeforeClass
    public void beforeclass() {
         driver = DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver, "https://dev.devstagging.online/");
        homePage = new HomePage(driver);
        registrationPage = new registrationPage(driver);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("User can register with valid data")
    public void User_Can_Register_sucessfully() {
        homePage.navigateToSignIn();
        homePage.navigate_to_SignUp();
        registrationPage.Fill_registration_form("057 076 2930", "3", "4", "9", "6", "Mostafa Ali", "mos@jf.com", "123456");
        Assertions.assertEquals("مرحبا Mostafa Ali", registrationPage.assertName());
        homePage.PressIcon_and_LogOut();

    }
    @Test(dependsOnMethods ="User_Can_Register_sucessfully" )
    @Severity(SeverityLevel.CRITICAL)
    @Description("User can't register with Phone number is exist ")
    public void Verify_User_Cannot_register_with_Phone_number_IsExist(){

        homePage.navigate_to_SignUp();
        registrationPage.register_with_phone_exist("0500000000");
        Assertions.assertEquals("رقم الهاتف مُسجل لدينا من قبل، ادخل رقم جديد!",registrationPage.error_message());
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("User Must Enter Phone number first!!!")
    public void Verify_User_Must_Enter_PhoneNumber_first(){
        registrationPage.PressLogo_andNavigatto_SignIn();
        homePage.navigateToSignIn();
        homePage.navigate_to_SignUp();
        registrationPage.user_cannot_register_without_phonenumber("");
        Assertions.assertEquals("من فضلك تأكد من رقم الهاتف",registrationPage.errorMessage_telling_enter_phoneFirst());

    }
    @AfterClass
    public void AfterCalss(){
        driver.quit();
    }
}
