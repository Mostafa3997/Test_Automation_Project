package TC.ChangePassword;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC_ChangePassword_API {
    String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGU5YTMwYmM1ZDQxZTcwMjM3NjZjYjMiLCJpYXQiOjE2MjU5MjQzNjN9.kWuILR0ERmnW3h4bieVwS2s7eAr6FAFqXchgw8C-HYI";
    @Test
    public void changePassword(){
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject changePassword=new JSONObject();
        changePassword.put("password","123456");
        changePassword.put("prevPassword","123456");
        apiobject.buildNewRequest("api/updateUser", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(changePassword)
                .addHeader("Authorization",token)
                .performRequest();
}
}
