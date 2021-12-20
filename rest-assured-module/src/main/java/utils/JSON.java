package utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class JSON {
    @SneakyThrows
    public static  <T> T jsonAs(Response response, Class<T> tClass) {
        return new com.fasterxml.jackson.databind.ObjectMapper().readValue(response.body().asString(), tClass);
    }
}
