package TC;
import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class APITest {
    @Test
    public void getAll_User(){
      RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");

      apiobject.buildNewRequest("api/getAllUsers/" , RestActions.RequestType.GET).performRequest();
}
     @Test
    public void register_user(){

         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
            JSONObject  creatuser=new JSONObject();
            creatuser.put("name","مصطفي");
            creatuser.put("password","123456");
            creatuser.put("phoneNumber","0599786387");
            creatuser.put("userType","600ea32e4f2ac87e4b098e2c");


          Response token= apiobject.buildNewRequest("api/addUser", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                 .setRequestBody(creatuser)
                 .performRequest();
          String User_token=RestActions.getResponseJSONValue(token,"token");

     }
     @Test
    public void Login_user(){

         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
         JSONObject  loginUser=new JSONObject();
         loginUser.put("phoneNumber","966500000000 ");
         loginUser.put("password","123456");
         Response  createToken =apiobject.buildNewRequest("api/loginUser", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                 .setRequestBody(loginUser)
                 .performRequest();
         String token = RestActions.getResponseJSONValue(createToken,"token");
         List<List<Object>> form = Arrays.asList(
                 Arrays.asList("type","600ea3f34e830d01fbeb24aa"),
                 Arrays.asList("status","5e255a4d73d070b548db7522"),
                 Arrays.asList("purpose","5e29a544cc164f5df863bcf7"),
                 Arrays.asList("space","600"),
                 Arrays.asList("price","9000"),
                 Arrays.asList("address.coordinates[0]","24.809453"),
                 Arrays.asList("address.coordinates[1]","46.619355"),
                 Arrays.asList("address.address","شارع محمد بن سعود"));
         apiobject.buildNewRequest("api/realEstate/addRealEstate", RestActions.RequestType.POST)
                 .setTargetStatusCode(200)
                 .setContentType(ContentType.fromContentType("multipart/form-data"))
                 .setParameters(form, RestActions.ParametersType.FORM)
                 .addHeader("Authorization","Bearer  " + token)
                 .performRequest();
     }
     @Test
    public void checkuser(){
         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
         JSONObject  checkuser=new JSONObject();
         checkuser.put("phoneNumber","0555879874");
         apiobject.buildNewRequest("api/checkUser", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                 .setRequestBody(checkuser)
                 .performRequest();

     }
     @Test
    public void confirmcode(){
         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
         JSONObject  confirmCode=new JSONObject();
         confirmCode.put("phoneNumber","0555879874");
         confirmCode.put("confirmationCode","3496");
         apiobject.buildNewRequest("api/confirmRegister", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                 .setRequestBody(confirmCode)
                 .performRequest();

     }
     @Test
    public void registerUser(){
         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
         JSONObject  registered=new JSONObject();
         registered.put("phoneNumber","058777896");
         registered.put("name","Mostafa Ali");
         registered.put("password","123456");
         registered.put("userType","600ea3b54e830d01fbeb24a8");
         apiobject.buildNewRequest("api/confirmRegister", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                 .setRequestBody(registered)
                 .performRequest();


     }
     @Test
    public void changePassword(){
         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
         JSONObject  ForgotPassword=new JSONObject();
         ForgotPassword.put("phoneNumber","0500000000");
         apiobject.buildNewRequest("api/resetPassword", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                 .setRequestBody(ForgotPassword)
                 .performRequest();


     }
     @Test
    public void addrealeste(){
        String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGU5YTMwYmM1ZDQxZTcwMjM3NjZjYjMiLCJpYXQiOjE2MjU5MjQzNjN9.kWuILR0ERmnW3h4bieVwS2s7eAr6FAFqXchgw8C-HYI";
         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
         List<List<Object>> form = Arrays.asList(
                 Arrays.asList("type","600ea3f34e830d01fbeb24aa"),
                 Arrays.asList("status","5e255a4d73d070b548db7522"),
                 Arrays.asList("purpose","5e29a544cc164f5df863bcf7"),
                 Arrays.asList("space","600"),
                 Arrays.asList("price","9000"),
                 Arrays.asList("address.coordinates[0]","24.809453"),
                 Arrays.asList("address.coordinates[1]","46.619355"),
                 Arrays.asList("address.address","شارع محمد بن سعود"));
         apiobject.buildNewRequest("api/realEstate/addRealEstate", RestActions.RequestType.POST)
                 .setTargetStatusCode(200)
                 .setParameters(form, RestActions.ParametersType.FORM)
                 .addHeader("Authorization",token)
                 .performRequest();

     }
     @Test
    public void helpcenter(){
        String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGU5Yzc2N2M1ZDQxZTcwMjM3NjZjZDQiLCJpYXQiOjE2MjU5MzM2NzF9.7Jexvl8rBf4rppeIlu__q51PvbAjWwPiEU1B-eVVz0E";
         RestActions apiobject=  DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/");
         JSONObject  help=new JSONObject();
         help.put("helpType","2");
         help.put("question","برجاء اصلاح جميع البجز");
         help.put("title","حتي يستطيع المستخدم استخدام الابلكيشن دون ملل");

         apiobject.buildNewRequest("api/addUserQuestion", RestActions.RequestType.POST)
                 .setContentType(ContentType.JSON)
                 .setRequestBody(help)
                 .addHeader("Authorization",token)
                 .performRequest();

     }








     }







