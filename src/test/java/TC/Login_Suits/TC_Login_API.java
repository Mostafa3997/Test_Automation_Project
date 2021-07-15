package TC.Login_Suits;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC_Login_API {


    @Test
    public void Login_user(){

        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject loginUser=new JSONObject();
        loginUser.put("phoneNumber","966500000000 ");
        loginUser.put("password","123456");
        apiobject.buildNewRequest("api/loginUser", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                .setRequestBody(loginUser)
                .performRequest();
}
}
