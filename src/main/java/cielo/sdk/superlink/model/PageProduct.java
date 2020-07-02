package cielo.sdk.superlink.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageProduct {

    private Integer totalCount;

    private Integer totalPages;

    private Integer pageIndex;

    private List<Product> products;    
    
}