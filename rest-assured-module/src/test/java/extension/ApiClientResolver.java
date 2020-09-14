package extension;

import api.client.ApiClient;
import api.client.Configuration;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class ApiClientResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType().isAssignableFrom(ApiClient.class);
    }

    @Override
    public ApiClient resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        var configuration = extensionContext.getStore(GLOBAL).get("config", Configuration.class);
        return ApiClient.api(configuration);
    }
}
