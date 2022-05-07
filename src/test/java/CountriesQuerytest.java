import data.DataRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static requests.ContinentsRequest.postContinents;

public class CountriesQuerytest {

    @Test
    public void shouldReturnStatus200(){
        Response response = postContinents(DataRequest.body, Constants.BASE_URL);
        response.
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void shouldReturnStatus200AndRequiredFields(){
        Response response = postContinents(DataRequest.body, Constants.BASE_URL);
       response.
                then().
                assertThat().statusCode(200).body("data.continents[0].code", equalTo(DataRequest.continent));
    }

    @Test
    public void shouldValidateType(){
        Response response = postContinents(DataRequest.body, Constants.BASE_URL);
        response.
                then().
                assertThat().body("data.continents", instanceOf(List.class));
    }

    @Test
    public void shouldReturnStatus400(){
        Response response = postContinents(DataRequest.bodyError, Constants.BASE_URL);
        response.
                then().
                assertThat().statusCode(400);
    }
}