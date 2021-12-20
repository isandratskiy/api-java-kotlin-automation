package api.controller;

import api.client.Configuration;
import api.operation.GetProductsCatalogueOper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CatalogueController {
    private final Configuration configuration;

    public static CatalogueController catalogue(Configuration configuration) {
        return new CatalogueController(configuration);
    }

    public GetProductsCatalogueOper getProducts() {
        return  new GetProductsCatalogueOper(this.configuration);
    }
}
