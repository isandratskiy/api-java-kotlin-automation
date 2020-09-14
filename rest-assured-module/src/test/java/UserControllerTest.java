import api.client.ApiClient;
import api.controller.UserController;
import entities.request.User;
import extension.ApiClientResolver;
import extension.SetupExtension;
import extension.UserResolver;
import io.restassured.response.ResponseOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({ApiClientResolver.class, UserResolver.class, SetupExtension.class})
public class UserControllerTest {
    private UserController userController;

    @BeforeEach
    void before(ApiClient client) {
        this.userController = client.user();
    }

    @Test
    void test(User user) {
        var status = userController.createUser().body(user).execute(ResponseOptions::statusCode);
        assertEquals(200, status);
    }
}
