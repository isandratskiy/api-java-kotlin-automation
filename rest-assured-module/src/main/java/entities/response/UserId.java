package entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserId {
	@JsonProperty("id")
	private String id;
}