import api.client.ApiClient;
import entities.request.ProductId;
import entities.request.User;
import entities.response.Product;
import extension.ApiClientInjector;
import extension.UserResolver;
import io.restassured.response.ResponseOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.ObjectMapper.getStringAs;

@ExtendWith({UserResolver.class, ApiClientInjector.class})
class CartControllerTest {
    ApiClient api;

    @BeforeEach
    void before(User user) {
        api.user().createUser()
                .body(user)
                .execute(ResponseOptions::thenReturn);
    }

    @Test
    void shouldAddProductToCart() {
        var productsId = api.catalogue().getProducts()
                .size("5")
                .execute(response -> stream(
                        getStringAs(response, Product[].class)).findAny().get().getId());

        var product = new ProductId().setId(productsId);
        api.cart().addProduct().body(product).execute(ResponseOptions::statusCode);

        var cartProductId = api.cart().getCartProduct()
                .execute(response -> stream(
                        getStringAs(response, Product[].class)).findFirst().get().getItemId());

        assertEquals(productsId, cartProductId);
    }
}
