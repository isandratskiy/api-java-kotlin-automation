package api.operation;

import api.client.Configuration;
import io.restassured.response.Response;

import java.util.function.Function;

public class GetProductCartOper extends RequestOperationHandler {
    public static final String CARD_URI = "/cart";

    public GetProductCartOper(Configuration configuration) {
        super(configuration);
    }

    @Override
    public <T> T execute(Function<Response, T> function) {
        super.reqSpec.addCookies(getCookies());
        var response = get(CARD_URI);
        return function.apply(response);
    }
}
