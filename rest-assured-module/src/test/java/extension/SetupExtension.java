package extension;

import api.client.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class SetupExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        var configuration = new Configuration();
        configuration.setRequestSpecBuilder(
                new RequestSpecBuilder()
                        .setContentType(JSON)
                        .setBaseUri("http://localhost")
                        .setPort(80)
                        .log(ALL));
        configuration.setResponseSpecBuilder(new ResponseSpecBuilder().log(ALL));
        context.getStore(GLOBAL).put("config", configuration);
    }
}