package cielo.lio.sdk.superlink;

import java.util.List;

import cielo.lio.sdk.superlink.model.Product;

public interface SuperLink {

    Product createLink(Product product);

    List<Product> getLinks();

    Product getLink(String id);

    void updateLink(String id, Product product);

    void deleteLink(String id);
    
}