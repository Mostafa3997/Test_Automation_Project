package TC.Registrations_Suits;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC_Registreation_API {
    String phoneNumber="966502102525";

    @Test
    public void checkuser(){
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject checkuser=new JSONObject();
        checkuser.put("phoneNumber",phoneNumber);
        apiobject.buildNewRequest("api/checkUser", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(checkuser)
                .setTargetStatusCode(200)
                .performRequest();

    }
    @Test(dependsOnMethods = "checkuser")
    public void confirmcode(){
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject  confirmCode=new JSONObject();
        confirmCode.put("phoneNumber",phoneNumber);
        confirmCode.put("confirmationCode","3496");
        apiobject.buildNewRequest("api/confirmRegister", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(confirmCode)
                .setTargetStatusCode(200)
                .performRequest();

    }
    @Test
    public void add_User(){
        RestActions apiobject =DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject adduser=new JSONObject();
        adduser.put("phoneNumber",phoneNumber);
        adduser.put("password","123456");

    }
    @Test(dependsOnMethods = "confirmcode")
    public void registerUser(){
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject  registered=new JSONObject();
        registered.put("phoneNumber",phoneNumber);
        registered.put("name","Mostafa Ali");
        registered.put("password","123456");
        registered.put("userType","600ea3b54e830d01fbeb24a8");
        apiobject.buildNewRequest("api/confirmRegister", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(registered)
                .setTargetStatusCode(200)
                .performRequest();


    }


}
