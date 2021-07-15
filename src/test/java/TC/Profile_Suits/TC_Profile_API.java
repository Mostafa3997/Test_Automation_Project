package TC.Profile_Suits;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC_Profile_API {
    String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MDJiY2QxODU2ODdiOTEwMmNmNTUwNmQiLCJpYXQiOjE2MTM0ODMyODh9.YBGyeauv2ft7GCk-aYTrBbFVGiEqnkNAo2ivKzZmYws";
    @Test
    public void USER_Can_Change_DATA(){
        RestActions apiobject=   DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject profile=new JSONObject();
        profile.put("email","Mostaf@udi.com");
        apiobject.buildNewRequest("api/updateUser", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(profile)
                .addHeader("Authorization",token)
                .performRequest();
    }
}
