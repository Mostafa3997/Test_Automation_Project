package TC.ForgotPassword_Suits;

import Pages.ForgotPassword;
import Pages.HomePage;
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

public class TC_ForgotPassword_GUI {
    private WebDriver driver;
    private HomePage homePage;
    private ForgotPassword forgotPassword;


    @BeforeClass
    public void beforeclass(){
        driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online/");
        homePage =new HomePage(driver);
        forgotPassword=new ForgotPassword(driver);


    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("User try To change Password")
    public void User_Can_ForgotPassword_Successfully(){
        homePage.navigateToSignIn();
        forgotPassword.Forgot_Password("0500000000","3","4","9","6","123456");
        //Assertions.assertEquals("تم إعادة تعيين كلمة المرور بنجاح!",forgotPassword.validationMessage());
    }
    @Test(dependsOnMethods = "User_Can_ForgotPassword_Successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User try to change password using invalid phone")
    public void Forgot_Password_Using_PhoneNumber_not_exist(){
        forgotPassword.forgotPasswordUsinginVailData("056 888 7887");
        Assertions.assertEquals("عفواً، الرقم الذي تحاول استرجاع كلمة مروره غير مُسجل",forgotPassword.Error_Message());

    }
    @AfterClass
    public void AfterCalss(){
        driver.quit();
    }

}
