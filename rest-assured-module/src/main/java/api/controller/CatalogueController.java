package api.controller;

import api.client.Configuration;
import api.operation.GetProductsCatalogueOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CatalogueController {
    private final Configuration configuration;

    public static CatalogueController catalogue(Configuration configuration) {
        return new CatalogueController(configuration);
    }

    public GetProductsCatalogueOperation getProducts() {
        return  new GetProductsCatalogueOperation(this.configuration);
    }
}
