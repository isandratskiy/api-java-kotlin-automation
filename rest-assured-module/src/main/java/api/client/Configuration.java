package api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Configuration {
    private RequestSpecBuilder requestSpecBuilder;
    private ResponseSpecBuilder responseSpecBuilder;
}
