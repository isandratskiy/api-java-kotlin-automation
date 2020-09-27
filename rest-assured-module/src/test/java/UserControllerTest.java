import api.client.ApiClient;
import entities.request.User;
import entities.response.UserId;
import extension.BaseSetup;
import io.restassured.response.ResponseOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@BaseSetup
class UserControllerTest {
    ApiClient api;

    @Test
    void shouldRegisterUser(User user) {
        var response = api.user()
                .createUser()
                .body(user)
                .execute(ResponseOptions::thenReturn);

        assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertNotNull(response.as(UserId.class).getId()));
    }
}
