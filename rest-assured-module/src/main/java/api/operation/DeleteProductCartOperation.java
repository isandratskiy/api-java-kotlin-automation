package api.operation;

import api.client.Configuration;
import io.restassured.response.Response;

import java.util.function.Function;

public class DeleteProductCartOperation extends OperationHandler {
    public static final String PRODUCT_CART_URI = "/cart/{id}";

    public DeleteProductCartOperation(Configuration configuration) {
        super(configuration);
    }

    @Override
    public <T> T execute(Function<Response, T> function) {
        super.reqSpec.addCookies(getCookies());
        var response = delete(PRODUCT_CART_URI);
        return function.apply(response);
    }

    public DeleteProductCartOperation productId(String id) {
        super.reqSpec.addPathParam("id", id);
        return this;
    }
}
