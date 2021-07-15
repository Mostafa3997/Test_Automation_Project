package TC.Search_Suits;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchPage;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Assertions;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Search_For_RealEstate {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
   private SearchPage searchPage;



    @BeforeClass
    public void beforeclass(){
        driver= DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://dev.devstagging.online/");
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        searchPage=new SearchPage(driver);

}
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void User_Can_Search_Successfully(){
        homePage.navigateToSignIn();
        loginPage.FillLogin_Form("0500000000","123456");
        searchPage.User_Search("الرياض");


    }
    @Test
    public void VerifyQuickSearch_ForSale(){

        searchPage.quickSearch();
        //Assertions.assertTrue(driver.findElement(By.xpath("//label[@class='btn btn-light active']//input[@value='600ea695e3672a38437e635c']")).isSelected());
    }
    @Test(dependsOnMethods = "VerifyQuickSearch_ForSale")
    public void VerifyQuickSearch_ForRent(){
        searchPage.quickSearchForRent();
        Assertions.assertTrue(driver.findElement(By.xpath("//label[@class='btn btn-light active']//input[@value='600ea695e3672a38437e635c']")).isSelected());

    }


}
