package api.controller;

import api.operation.RegisterUserOperation;
import io.restassured.builder.RequestSpecBuilder;

public class UserController {
    private final RequestSpecBuilder reqSpec;

    public static UserController user(RequestSpecBuilder reqSpec) {
        return new UserController(reqSpec);
    }

    private UserController(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public RegisterUserOperation createUser() {
        return new RegisterUserOperation(this.reqSpec);
    }
}
