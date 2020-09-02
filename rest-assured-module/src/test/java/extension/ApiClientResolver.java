package extension;

import api.client.ApiClient;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import static api.client.ApiClient.Config.apiConfig;

public class ApiClientResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType().isAssignableFrom(ApiClient.class);
    }

    @Override
    public ApiClient resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return ApiClient.api(apiConfig().buildRequestSpec());
    }
}
