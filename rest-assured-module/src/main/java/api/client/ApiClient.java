package api.client;

import api.controller.UserController;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiClient {
    private final Configuration configuration;

    public static ApiClient api(Configuration configuration) {
        return new ApiClient(configuration);
    }

    public UserController user() {
        return UserController.user(this.configuration);
    }
}
