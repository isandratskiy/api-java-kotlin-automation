import api.client.ApiClient;
import entities.request.ProductId;
import entities.request.User;
import entities.response.Product;
import extension.BaseSetup;
import io.restassured.response.ResponseOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.ObjectMapper.stringAs;

@BaseSetup
class CartControllerTest {
    ApiClient api;

    @BeforeEach
    void before(User user) {
        api.user()
                .createUser()
                .body(user)
                .execute(ResponseOptions::thenReturn);
    }

    @Test
    void shouldAddProductToCart() {
        var productId = api.catalogue()
                .getProducts()
                .size("5")
                .execute(response -> stream(stringAs(response, Product[].class))
                        .findAny()
                        .get()
                        .getId());

        api.cart()
                .addProduct()
                .body(new ProductId().setId(productId))
                .execute(ResponseOptions::thenReturn);

        var cartProductId = api.cart()
                .getCartProduct()
                .execute(response -> stream(stringAs(response, Product[].class))
                        .findFirst()
                        .get()
                        .getItemId());

        assertEquals(productId, cartProductId, "Product id is not same");
    }

    @Test
    void shouldRemoveProductFromCart() {
        var productId = api.catalogue()
                .getProducts()
                .size("5")
                .execute(response -> stream(stringAs(response, Product[].class))
                        .findAny()
                        .get()
                        .getId());

        api.cart()
                .addProduct()
                .body(new ProductId().setId(productId))
                .execute(ResponseOptions::thenReturn);

        api.cart()
                .deleteCartProduct()
                .productId(productId)
                .execute(ResponseOptions::statusCode);

        var size = api.cart()
                .getCartProduct()
                .execute(response -> (int) stream(stringAs(response, Product[].class)).count());

        assertEquals(0, size);


    }
}
