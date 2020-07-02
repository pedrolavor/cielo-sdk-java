package cielo.sdk.superlink;

import cielo.sdk.superlink.model.PageProduct;
import cielo.sdk.superlink.model.Product;
import cielo.sdk.superlink.model.ProductFilter;

public interface SuperLink {

    Product createLink(Product product);

    PageProduct getLinks(ProductFilter filter);

    Product getLink(String id);

    void updateLink(String id, Product product);

    void deleteLink(String id);
    
}