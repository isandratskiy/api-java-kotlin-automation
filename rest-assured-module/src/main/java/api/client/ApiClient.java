package api.client;

import api.controller.UserController;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;

import java.util.function.Supplier;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class ApiClient {
    private final Config config;

    private ApiClient(Config config) {
        this.config = config;
    }

    public static ApiClient api(Config config) {
        return new ApiClient(config);
    }

    public UserController user() {
        return UserController.user(config.baseReqSpec.get());
    }

    public static class Config {
        private Supplier<RequestSpecBuilder> baseReqSpec;

        public static Config apiConfig() {
            return new Config();
        }

        public Config setRequestSpec(Supplier<RequestSpecBuilder> supplier) {
            this.baseReqSpec = supplier;
            return this;
        }

        public Config buildRequestSpec() {
            this.setRequestSpec(
                    () -> new RequestSpecBuilder()
                            .setContentType(JSON)
                            .addFilter(new ErrorLoggingFilter())
                            .setBaseUri("http://localhost")
                            .setPort(80)
                            .log(ALL));
            return this;
        }
    }
}
