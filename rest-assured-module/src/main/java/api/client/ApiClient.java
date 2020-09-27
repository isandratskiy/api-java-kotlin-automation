package api.client;

import api.controller.CartController;
import api.controller.CatalogueController;
import api.controller.UserController;

import static api.client.Configuration.config;

public class ApiClient {
    public static ApiClient api() {
        return new ApiClient();
    }

    private ApiClient() {
    }

    public UserController user() {
        return UserController.user(config().build());
    }

    public CatalogueController catalogue() {
        return CatalogueController.catalogue(config().build());
    }

    public CartController cart() {
        return CartController.cart(config().build());
    }
}
