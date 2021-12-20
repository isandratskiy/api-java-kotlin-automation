import api.client.ApiClient;
import entities.request.ProductId;
import entities.request.User;
import entities.response.Product;
import extension.Setup;
import io.restassured.response.ResponseOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.JSON.jsonAs;

@Setup
class CartControllerTest {
    ApiClient api;
    String productId;

    @BeforeEach
    void before(User user) {
        api.user()
                .createUser()
                .body(user)
                .execute(ResponseOptions::thenReturn);

        productId = api.catalogue()
                .getProducts()
                .size("5")
                .execute(response -> stream(jsonAs(response, Product[].class))
                        .findAny()
                        .get()
                        .getId());

        api.cart()
                .addProduct()
                .body(new ProductId().setId(productId))
                .execute(ResponseOptions::thenReturn);
    }

    @Test
    void shouldAddProductToCart() {
        var cartProductId = api.cart()
                .getCartProduct()
                .execute(response -> stream(jsonAs(response, Product[].class))
                        .findFirst()
                        .get()
                        .getItemId());

        assertEquals(productId, cartProductId, "Product id is not same");
    }

    @Test
    void shouldRemoveProductFromCart() {
        api.cart()
                .deleteCartProduct()
                .productId(productId)
                .execute(ResponseOptions::statusCode);

        var size = api.cart()
                .getCartProduct()
                .execute(response -> (int) stream(jsonAs(response, Product[].class)).count());

        assertEquals(0, size, "Cart is not empty");
    }
}
