package api.controller;

import api.client.Configuration;
import api.operation.AddProductCartOperation;
import api.operation.GetProductCartOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CartController {
    private final Configuration configuration;

    public static CartController cart(Configuration configuration) {
        return new CartController(configuration);
    }

    public AddProductCartOperation addProduct() {
        return new AddProductCartOperation(this.configuration);
    }

    public GetProductCartOperation getCartProduct() {
        return new GetProductCartOperation(this.configuration);
    }

}
