package api.homeEndpointTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import endpoints.api;
import io.restassured.response.Response;
import utility.Helper;

class PostHomeTest extends Helper {

    @Test(groups = { "ApiTest" })
    public void assertStatusCodeHomeApi() {
        JSONObject object = new JSONObject();
        object.put("name", "test");
        object.put("salary", "123");
        object.put("age", "23");
        Response response = api.homePageEndpoint.PostEmployeeApi(object);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
