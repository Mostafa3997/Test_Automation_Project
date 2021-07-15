package TC.UPdate_RealEstate_Suits;

import Pages.*;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Update_RealEstate {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
  private UpdateRealEstePage updateRealEstePage;
  private Add_RealEstatePage add_realEstatePage;



    @BeforeClass
    public void beforeclass(){
        driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online/");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        updateRealEstePage=new UpdateRealEstePage(driver);
        add_realEstatePage=new Add_RealEstatePage(driver);


    }
    @Test
    public void User_Edit(){
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.navigate_To_AddRealEstate();
        add_realEstatePage.User_Add_RealEstat_Villa("1322","366","36","الرياض");
        updateRealEstePage.Edit();
        Assertions.assertEquals("تم تحديث العقار بنجاح!",updateRealEstePage.assertMessage());

    }
}
