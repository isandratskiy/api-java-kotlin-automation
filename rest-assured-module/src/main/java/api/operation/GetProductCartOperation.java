package api.operation;

import api.client.Configuration;
import io.restassured.response.Response;

import java.util.function.Function;

public class GetProductCartOperation extends OperationHandler {
    public static final String CARD_URI = "/cart";

    public GetProductCartOperation(Configuration configuration) {
        super(configuration);
    }

    @Override
    public <T> T execute(Function<Response, T> function) {
        super.reqSpec.addCookies(getCookies());
        var response = get(CARD_URI);
        return function.apply(response);
    }
}
