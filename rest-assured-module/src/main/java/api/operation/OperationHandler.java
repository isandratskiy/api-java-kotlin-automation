package api.operation;

import api.client.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class OperationHandler {
    public static Map<String, String> cookies = new HashMap<>();

    protected ResponseSpecBuilder respSpec;
    protected RequestSpecBuilder reqSpec;

    public OperationHandler(Configuration configuration) {
        this.reqSpec = configuration.getRequestSpecBuilder();
        this. respSpec = configuration.getResponseSpecBuilder();
    }

    protected Response post(String url) {
        return given()
                .when()
                .spec(reqSpec.build())
                .post(url)
                .then()
                .spec(respSpec.build())
                .extract()
                .response();
    }
}
