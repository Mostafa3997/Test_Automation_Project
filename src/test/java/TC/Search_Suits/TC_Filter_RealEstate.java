package TC.Search_Suits;

import Pages.*;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Filter_RealEstate {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private Filter_RealEstatePage filter_realEstatePage;

    @BeforeClass
    public void berforeClass (){
        driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        filter_realEstatePage=new Filter_RealEstatePage(driver);
        searchPage =new SearchPage(driver);


    }
    @Test
    public void FilterRealEste(){
      //  homePage.navigateToSignIn();
        //loginPage.FillLogin_Form("0500000000","123456");
        searchPage.quickSearch();
        filter_realEstatePage.Filter();



    }
    @AfterClass
    public void afterclass(){
        driver.quit();

    }
}
