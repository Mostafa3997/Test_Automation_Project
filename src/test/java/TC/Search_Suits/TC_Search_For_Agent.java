package TC.Search_Suits;

import Pages.Add_RealEstatePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Search_For_Agent;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Search_For_Agent {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private Add_RealEstatePage add_realEstatePage;
    private Search_For_Agent search_for_agent;

    @BeforeClass
    public void berforeClass (){
        driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        search_for_agent=new Search_For_Agent(driver);
        add_realEstatePage=new Add_RealEstatePage(driver);

    }
    @Test
    public void User_Can_Search_For_his_office() {
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0569888999","123456");
        homePage.navigate_To_AddRealEstate();
        add_realEstatePage.User_Add_RealEstat_flat("10000","369","15","الرياض");
        search_for_agent.clickLogo();
        search_for_agent.User_Search_For_Agent("الدمام");
        Assertions.assertEquals("شركة الخيرات للعقارات",search_for_agent.getname());

    }

}
