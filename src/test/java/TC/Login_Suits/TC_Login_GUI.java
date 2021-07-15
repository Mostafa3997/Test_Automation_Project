package TC.Login_Suits;

import Pages.HomePage;
import Pages.LoginPage;
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

public class TC_Login_GUI {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    @BeforeClass
    public void berforeClass (){
        driver= DriverFactory.getDriver();
          BrowserActions.navigateToURL(driver,"https://dev.devstagging.online");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);


    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login With a valid  User")
    public void  SignIn_With_valid_data(){
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.User_LogOut();

    }
    @Test(dependsOnMethods = "SignIn_With_valid_data")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login With invalid data")
    public void SignIN_Invalid_data(){

        loginPage.FillLogin_Form("0533666565","1234588");
        Assertions.assertEquals("من فضلك تأكد من رقم جوالك وكلمة المرور",loginPage.Error_Messga());
    }
    @Test(dependsOnMethods = "SignIN_Invalid_data")
    @Severity(SeverityLevel.MINOR)
    @Description("Login with Leaving both Phone number and password fields  empty ")
    public void Login_with_Leaving_both_Phone_number_and_Passwor_fields_empty(){

        loginPage.Login_with_Leaving_field_empty();
        Assertions.assertEquals("من فضلك تأكد من البيانات",loginPage.Error_Messga());
    }
    @AfterClass
    public void AfterCalss(){
        driver.quit();
    }



}
