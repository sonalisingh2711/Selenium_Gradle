package endpoints;


import config.endpoints;
import org.json.JSONObject;
import io.restassured.response.Response;
import utility.ApiHelper;

public class HomePageEndpoint {

    public Response PostEmployeeApi(JSONObject body) {
        String url = endpoints.POST_EMPLOYEE;
        Response response = ApiHelper.post(url, body);
        return response;
    }

    public Response GetEmployeeApi() {
        String url = endpoints.GET_EMPLOYEE;
        Response response = ApiHelper.get(url);
        return response;
    }
}
