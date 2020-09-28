package utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ObjectMapper {
    @SneakyThrows
    public static  <T> T stringAs(Response response, Class<T> tClass) {
        return new com.fasterxml.jackson.databind.ObjectMapper().readValue(response.body().asString(), tClass);
    }
}
