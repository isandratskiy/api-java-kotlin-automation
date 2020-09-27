package entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class ProductId {
    @JsonProperty("id")
    private String id;
}
