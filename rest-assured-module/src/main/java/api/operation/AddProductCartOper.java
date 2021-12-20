package api.operation;

import api.client.Configuration;
import entities.request.ProductId;
import io.restassured.response.Response;

import java.util.function.Function;

public class AddProductCartOper extends RequestOperationHandler {
    public static final String CART_URI = "/cart";

    public AddProductCartOper(Configuration configuration) {
        super(configuration);
    }

    @Override
    public <T> T execute(Function<Response, T> function) {
        super.reqSpec.addCookies(getCookies());
        var response = post(CART_URI);
        return function.apply(response);
    }

    public AddProductCartOper body(ProductId id) {
        super.reqSpec.setBody(id);
        return this;
    }
}
