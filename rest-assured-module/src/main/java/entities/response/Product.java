package entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	@JsonProperty("price")
	private double price;

	@JsonProperty("imageUrl")
	private List<String> imageUrl;

	@JsonProperty("name")
	private String name;

	@JsonProperty("count")
	private int count;

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private String id;

	@JsonProperty("itemId")
	private String itemId;

	@JsonProperty("tag")
	private List<String> tag;
}