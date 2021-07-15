package TC.AddRealEstat_suits;

import Pages.Add_RealEstatePage;
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

public class TC1_Add_RealEstate_GUI {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private Add_RealEstatePage add_realEstatePage;
    @BeforeClass
    public void beforeclass() {
         driver = DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver, "https://dev.devstagging.online/");
        homePage = new HomePage(driver);
        loginPage =new LoginPage(driver);
        add_realEstatePage=new Add_RealEstatePage(driver);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that the user can add real Estate successfully ")
    public void USer_Can_AddRealEstat_Flat(){
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0500000000","123456");
        homePage.navigate_To_AddRealEstate();
        add_realEstatePage.User_Add_RealEstat_flat("10000","250","5","الرياض");
        Assertions.assertEquals("الرياض",add_realEstatePage.locationAssertions());

    }
    @Test(dependsOnMethods = "USer_Can_AddRealEstat_Flat")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify the user can add real Estate which villa")

    public void  USer_Can_AddRealEstat_Villa(){
        homePage.navigate_To_AddRealEstate();
        add_realEstatePage.User_Add_RealEstat_Villa("50000","3000","96","الرياض");
        Assertions.assertEquals("الرياض",add_realEstatePage.locationAssertions());



    }
    @Test(dependsOnMethods = "USer_Can_AddRealEstat_Villa")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that the user can add real Estate which land successfully")
    public void USer_Can_AddRealEstat_Land(){
        homePage.navigate_To_AddRealEstate();
        add_realEstatePage.User_Add_RealEstat_Land("1000000","298","الرياض");
        Assertions.assertEquals("الرياض",add_realEstatePage.locationAssertions());
    }
    @Test(dependsOnMethods = "USer_Can_AddRealEstat_Land")
    @Severity(SeverityLevel.BLOCKER)
    public void USer_Can_AddRealEstat_Building(){
        homePage.navigate_To_AddRealEstate();
        add_realEstatePage.User_Add_RealEstat_Villa("50000","3000","96","الرياض");
        Assertions.assertEquals("الرياض",add_realEstatePage.locationAssertions());



    }
    @AfterClass
    public void after(){
        driver.quit();
    }
}
