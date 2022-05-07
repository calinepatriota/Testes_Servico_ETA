import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static requests.ContinentsRequest.postContinents;
import static requests.RequestBase.getValueFromResponse;

public class CountriesQuerytest {

    String body = "{\"query\":\"\\r\\nquery{\\r\\n  continents(filter:{\\r\\n    code:\\r\\n    {\\r\\n      in:[\\\"AF\\\"]\\r\\n    }\\r\\n    })\\r\\n\\t{\\r\\n    code\\r\\n    }\\r\\n  }\\r\\n\",\"variables\":{}}";
    String bodyError = "{\"query\":\"\\r\\nquery{\\r\\n  (filter:{\\r\\n    code:\\r\\n    {\\r\\n      in:[\\\"AF\\\"]\\r\\n    }\\r\\n    })\\r\\n\\t{\\r\\n    code\\r\\n    }\\r\\n  }\\r\\n\",\"variables\":{}}";


    @Test
    public void shouldReturnStatus200(){
        Response response = postContinents(body, Constants.BASE_URL);
        response.
                then().log().all().
                assertThat().statusCode(200);
    }

    @Test
    public void shouldReturnStatus200AndRequiredFields(){
        Response response = postContinents(body, Constants.BASE_URL);
        String value = getValueFromResponse(response, "data.continents[0].code");
        System.out.println(value);
       response.
                then().log().all().
                assertThat().statusCode(200).body("data.continents[0].code", equalTo(value));
    }

    @Test
    public void shouldValidateType(){
        Response response = postContinents(body, Constants.BASE_URL);
        String value = getValueFromResponse(response, "data.continents[0].code");
        System.out.println(value);
        response.
                then().log().all().
                assertThat().body("data.continents", instanceOf(List.class));
    }

    @Test
    public void shouldReturnStatus400(){
        Response response = postContinents(bodyError, Constants.BASE_URL);
        response.
                then().log().all().
                assertThat().statusCode(400);
    }
}