package api.operation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class SharedOperation {
    public static Map<String, String> cookies = new HashMap<>();

    protected static Response post(RequestSpecBuilder reqSpec, ResponseSpecBuilder respSpec, String url) {
        return given()
                .spec(reqSpec.build())
                .when()
                .post(url)
                .then()
                .spec(respSpec.build())
                .extract()
                .response();
    }
}
