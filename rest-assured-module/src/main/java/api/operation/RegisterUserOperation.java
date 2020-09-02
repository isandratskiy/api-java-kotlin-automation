package api.operation;

import entities.request.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.util.function.Function;

import static io.restassured.filter.log.LogDetail.ALL;

public class RegisterUserOperation extends SharedOperation {
    public static final String REQ_URI = "/register";

    private final RequestSpecBuilder reqSpec;
    private final ResponseSpecBuilder respSpec;

    public RegisterUserOperation(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
        this.respSpec = new ResponseSpecBuilder().log(ALL);
    }

    public RegisterUserOperation(RequestSpecBuilder reqSpec, ResponseSpecBuilder respSpec) {
        this.reqSpec = reqSpec;
        this.respSpec = respSpec;
    }

    public <T> T execute(Function<Response, T> handler) {
        var response = post(reqSpec, respSpec, REQ_URI);
        cookies.putAll(response.cookies());
        return handler.apply(response);
    }

    public RegisterUserOperation body(User body) {
        reqSpec.setBody(body);
        return this;
    }
}
