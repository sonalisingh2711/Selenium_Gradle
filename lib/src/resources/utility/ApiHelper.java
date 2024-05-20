package utility;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class ApiHelper extends Helper {
    static String base_url = Environment.getValue("API", "BASE_URL");

    public static Response post(String endpoint, JSONObject body) {
        // request the server
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(body.toString());
        logger.info("POST Url:" + base_url + endpoint);
        Response response = requestSpecification.post(base_url + endpoint);
        return response;
    }

    public static Response get(String endpoint) {
        // request the server
        RequestSpecification requestSpecification = RestAssured.given();
        logger.info("GET Url:" + base_url + endpoint);
        Response response = requestSpecification.get(base_url + endpoint);
        return response;
    }

    public static Response delete(String endpoint, JSONObject body) {
        // request the server
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(body.toString());
        logger.info("DELETE Url:" + base_url + endpoint);
        Response response = requestSpecification.delete(base_url + endpoint);
        return response;
    }

    public static Response put(String endpoint, JSONObject body) {
        // request the server
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(body.toString());
        logger.info("PUT Url:" + base_url + endpoint);
        Response response = requestSpecification.put(base_url + endpoint);
        return response;
    }

    public static String assertResponseBody(Response response, String key) {
        ResponseBody body = response.getBody();
        JsonPath jsonPath = body.jsonPath();
        String value = jsonPath.get(key);
        return value;
    }
}