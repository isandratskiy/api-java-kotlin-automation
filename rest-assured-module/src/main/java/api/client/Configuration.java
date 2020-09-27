package api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import lombok.Getter;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

@Getter
public class Configuration {
    private RequestSpecBuilder requestSpecBuilder;
    private ResponseSpecBuilder responseSpecBuilder;

    public static Configuration config() {
        return new Configuration();
    }

    private Configuration() {
    }

    public Configuration build() {
        this.requestSpecBuilder = new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri("http://localhost")
                .setPort(80)
                .log(ALL);
        this.responseSpecBuilder = new ResponseSpecBuilder().log(ALL);
        return this;
    }
}
