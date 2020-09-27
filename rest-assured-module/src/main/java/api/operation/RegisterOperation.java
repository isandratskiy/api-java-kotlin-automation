package api.operation;

import api.client.Configuration;
import entities.request.User;
import io.restassured.response.Response;

import java.util.function.Function;

public class RegisterOperation extends OperationHandler {
    public static final String REQ_URI = "/register";

    public RegisterOperation(Configuration configuration) {
        super(configuration);
    }

    @Override
    public <T> T execute(Function<Response, T> function) {
        var response = post(REQ_URI);
        setCookies(response.getCookies());
        return function.apply(response);
    }

    public RegisterOperation body(User body) {
        super.reqSpec.setBody(body);
        return this;
    }
}
