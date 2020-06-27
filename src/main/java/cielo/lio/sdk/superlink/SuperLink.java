package cielo.lio.sdk.superlink;

import java.util.List;

import cielo.lio.sdk.superlink.model.Product;

public interface SuperLink {

    public Product createLink(Product product);

    public List<Product> getLinks();

    public Product getLink(String id);

    public void updateLink(String id, Product product);

    public void deleteLink(String id);
    
}