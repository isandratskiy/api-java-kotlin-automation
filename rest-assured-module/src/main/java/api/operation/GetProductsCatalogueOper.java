package api.operation;

import api.client.Configuration;
import io.restassured.response.Response;

import java.util.function.Function;

public class GetProductsCatalogueOper extends RequestOperationHandler {
    public static final String CATALOGUE_URI = "/catalogue?size={size}";

    public GetProductsCatalogueOper(Configuration configuration) {
        super(configuration);
    }

    @Override
    public <T> T execute(Function<Response, T> function) {
        super.reqSpec.addCookies(getCookies());
        var response = get(CATALOGUE_URI);
        return function.apply(response);
    }

    public GetProductsCatalogueOper size(String size) {
        super.reqSpec.addPathParam("size", size);
        return this;
    }
}
