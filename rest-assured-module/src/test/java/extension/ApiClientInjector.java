package extension;

import api.client.ApiClient;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import static java.util.Arrays.stream;

public class ApiClientInjector implements TestInstancePostProcessor {

    @SneakyThrows
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        var serviceField = stream(testInstance.getClass().getDeclaredFields())
                .filter(x -> x.getType().isAssignableFrom(ApiClient.class))
                .findFirst()
                .orElseThrow(() -> new NoSuchFieldException("Not found ApiClient.class field"));

        serviceField.setAccessible(true);
        serviceField.set(testInstance, ApiClient.api());
    }
}
