package api.controller;

import api.client.Configuration;
import api.operation.RegisterOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserController {
    private final Configuration configuration;

    public static UserController user(Configuration configuration) {
        return new UserController(configuration);
    }

    public RegisterOperation createUser() {
        return new RegisterOperation(this.configuration);
    }
}
