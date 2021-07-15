package TC.AddRealEstat_suits;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class TC_AddRealEstate_API {
    String token="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGU5Yzc2N2M1ZDQxZTcwMjM3NjZjZDQiLCJpYXQiOjE2MjU5MzM2NzF9.7Jexvl8rBf4rppeIlu__q51PvbAjWwPiEU1B-eVVz0E";

    @Test
    public void addrealEstate(){

        List<List<Object>> form = Arrays.asList(
                Arrays.asList("type","600ea3f34e830d01fbeb24aa"),
                Arrays.asList("status","600ea6ade3672a38437e635d"),
                Arrays.asList("purpose","60d1cddfe6f4a92869aa0d76"),
                Arrays.asList("space","600"),
                Arrays.asList("price","9000"),
                Arrays.asList("address.coordinates[0]","26.4206828"),
                Arrays.asList("address.coordinates[1]","50.0887943"),
                Arrays.asList("address.type","Point"),
                Arrays.asList("address.address","الدمام"));
         DriverFactory.getAPIDriver("https://devbackend.devstagging.online:9090/")
                  .buildNewRequest("api/realEstate/addRealEstate", RestActions.RequestType.POST)
                  .setTargetStatusCode(200)
                  .setParameters(form, RestActions.ParametersType.FORM)
                  .addHeader("Authorization",token )
                  .setContentType(ContentType.URLENC)
                  .performRequest();
    }

}
