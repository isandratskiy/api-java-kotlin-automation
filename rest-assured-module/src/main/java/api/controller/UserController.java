package api.controller;

import api.client.Configuration;
import api.operation.RegisterOper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserController {
    private final Configuration configuration;

    public static UserController user(Configuration configuration) {
        return new UserController(configuration);
    }

    public RegisterOper createUser() {
        return new RegisterOper(this.configuration);
    }
}
