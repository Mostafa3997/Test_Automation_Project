package TC.ForgotPassword_Suits;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC_Forgot_Password_API {
    String PhoneNumber="966555879874";

    @Test
    public void changePassword(){
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject ForgotPassword=new JSONObject();
        ForgotPassword.put("phoneNumber",PhoneNumber);
        apiobject.buildNewRequest("api/forgetPassword", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(ForgotPassword)
                .performRequest();
    }
    @Test(dependsOnMethods = "changePassword")
    public void ConfirmCode_ForgotPassword(){
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject  confirmCode=new JSONObject();
        confirmCode.put("phoneNumber",PhoneNumber);
        confirmCode.put("confirmationCode","3496");
        apiobject.buildNewRequest("api/confirmForgetCode", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(confirmCode)
                .performRequest();


    }
    @Test(dependsOnMethods = "ConfirmCode_ForgotPassword")
    public void ResetPassword(){
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject  resetpassword=new JSONObject();
        resetpassword.put("phoneNumber",PhoneNumber);
        resetpassword.put("password","123456");
        resetpassword.put("confirmationCode","3496");
        apiobject.buildNewRequest("api/resetPassword", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(resetpassword)
                .performRequest();


    }



}
