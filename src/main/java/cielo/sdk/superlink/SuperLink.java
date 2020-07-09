package cielo.sdk.superlink;

import cielo.sdk.superlink.model.PageProduct;
import cielo.sdk.superlink.model.Product;
import cielo.sdk.superlink.model.ProductFilter;
import cielo.sdk.superlink.model.order.LinkOrder;
import cielo.sdk.superlink.model.order.LinkOrders;

public interface SuperLink {

    Product createLink(Product product);

    PageProduct getLinks(ProductFilter filter);

    Product getLink(String linkId);

    LinkOrders getLinkOrders(String linkId);

    LinkOrder getLinkOrder(String orderNumber);

    void updateLink(String linkId, Product product);

    void deleteLink(String linkId);
    
}