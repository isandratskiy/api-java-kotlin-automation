package api.operation;

import api.client.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static io.restassured.RestAssured.given;

public abstract class OperationHandler {
    private static final ThreadLocal<Map<String, String>> COOKIES = new ThreadLocal<>();

    protected ResponseSpecBuilder respSpec;
    protected RequestSpecBuilder reqSpec;

    public OperationHandler(Configuration configuration) {
        this.reqSpec = configuration.getRequestSpecBuilder();
        this.respSpec = configuration.getResponseSpecBuilder();
    }

    public abstract <T> T execute(Function<Response, T> function);

    protected String getLoggedCookie() {
        return COOKIES.get().get("logged_in");
    }

    protected Map<String, String> getCookies() {
        return COOKIES.get();
    }

    protected void setCookies(Map<String, String> cookies) {
        COOKIES.set(new HashMap<>(cookies));
    }

    protected Response post(String url) {
        return given()
                .spec(reqSpec.build())
                .post(url)
                .then()
                .spec(respSpec.build())
                .extract()
                .response();
    }

    protected Response get(String url) {
        return given()
                .spec(reqSpec.build())
                .get(url)
                .then()
                .spec(respSpec.build())
                .extract()
                .response();
    }

    protected Response delete(String url) {
        return given()
                .spec(reqSpec.build())
                .delete(url)
                .then()
                .spec(respSpec.build())
                .extract()
                .response();
    }
}
