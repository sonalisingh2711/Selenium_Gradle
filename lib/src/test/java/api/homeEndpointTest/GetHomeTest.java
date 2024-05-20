package api.homeEndpointTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import endpoints.api;
import io.restassured.response.Response;
import utility.ApiHelper;
import utility.Helper;

class GetHomeTest extends Helper {

    static Response response;

    @BeforeClass(alwaysRun = true)
    public void getResponsedata() {
        response = api.homePageEndpoint.GetEmployeeApi();
    }

    @Test(groups = { "ApiTest" })
    public void assertStatusCodeApi() {
        // Response response = api.homePageEndpoint.GetEmployeeApi();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(groups = { "ApiTest" })
    public void assertResponseStatusValueApi() {
        // Response response = api.homePageEndpoint.GetEmployeeApi();
        String value = ApiHelper.assertResponseBody(response, "status");
        Assert.assertEquals(value, "success");
    }

}