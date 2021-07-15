package TC.Help_Center;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC_HelpCenter_API {
    @Test
    public void helpcenterMessage(){
        String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGU5Yzc2N2M1ZDQxZTcwMjM3NjZjZDQiLCJpYXQiOjE2MjU5MzM2NzF9.7Jexvl8rBf4rppeIlu__q51PvbAjWwPiEU1B-eVVz0E";
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject help=new JSONObject();
        help.put("helpType","2");
        help.put("question","برجاء اصلاح جميع البجز");
        help.put("title","حتي يستطيع المستخدم استخدام الابلكيشن دون ملل");

        apiobject.buildNewRequest("api/addUserQuestion", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(help)
                .addHeader("Authorization",token)
                .performRequest();

    }

    @Test(dependsOnMethods = "helpcenterMessage")
    public void helpcentersuggestion(){
        String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGU5Yzc2N2M1ZDQxZTcwMjM3NjZjZDQiLCJpYXQiOjE2MjU5MzM2NzF9.7Jexvl8rBf4rppeIlu__q51PvbAjWwPiEU1B-eVVz0E";
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject  help=new JSONObject();
        help.put("helpType","0");
        help.put("question","برجاء اصلاح جميع البجز");
        help.put("title","حتي يستطيع المستخدم استخدام الابلكيشن دون ملل");

        apiobject.buildNewRequest("api/addUserQuestion", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(help)
                .addHeader("Authorization",token)
                .performRequest();

    }

    @Test(dependsOnMethods = "helpcentersuggestion")
    public void helpcenterProblem(){
        String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGU5Yzc2N2M1ZDQxZTcwMjM3NjZjZDQiLCJpYXQiOjE2MjU5MzM2NzF9.7Jexvl8rBf4rppeIlu__q51PvbAjWwPiEU1B-eVVz0E";
        RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
        JSONObject  help=new JSONObject();
        help.put("helpType","1");
        help.put("question","برجاء اصلاح جميع البجز");
        help.put("title","حتي يستطيع المستخدم استخدام الابلكيشن دون ملل");

        apiobject.buildNewRequest("api/addUserQuestion", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(help)
                .addHeader("Authorization",token)
                .performRequest();

    }
}
