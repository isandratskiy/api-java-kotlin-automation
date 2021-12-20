package api.controller;

import api.client.Configuration;
import api.operation.AddProductCartOper;
import api.operation.DeleteProductCartOper;
import api.operation.GetProductCartOper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CartController {
    private final Configuration configuration;

    public static CartController cart(Configuration configuration) {
        return new CartController(configuration);
    }

    public AddProductCartOper addProduct() {
        return new AddProductCartOper(this.configuration);
    }

    public GetProductCartOper getCartProduct() {
        return new GetProductCartOper(this.configuration);
    }

    public DeleteProductCartOper deleteCartProduct() {
        return new DeleteProductCartOper(this.configuration);
    }

}
