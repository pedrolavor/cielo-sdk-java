package cielo.sdk.superlink;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import cielo.sdk.superlink.model.Product;
import cielo.sdk.superlink.model.Shipping;

public class DecimalPropertiesModelsTest {

    @Test
    public void whenPassingBigDecimal_thenConvertToInteger() {

        Product product = new Product();
        Shipping shipping = new Shipping();

        product.setPrice(BigDecimal.valueOf(35.97));
        product.setWeight(BigDecimal.valueOf(40));
        shipping.setPrice(BigDecimal.valueOf(345.37));

        assertEquals(Integer.valueOf(3597), product.getPrice());
        assertEquals(Integer.valueOf(4000), product.getWeight());
        assertEquals(Integer.valueOf(34537), shipping.getPrice());

        product.setPrice(BigDecimal.valueOf(35.97538962));
        product.setWeight(BigDecimal.valueOf(40.00956));
        shipping.setPrice(BigDecimal.valueOf(345.377906));

        assertEquals(Integer.valueOf(3597), product.getPrice());
        assertEquals(Integer.valueOf(4000), product.getWeight());
        assertEquals(Integer.valueOf(34537), shipping.getPrice());
    }

    @Test
    public void whenPassingDouble_thenConvertToInteger() {

        Product product = new Product();
        Shipping shipping = new Shipping();

        product.setPrice(35.97);
        product.setWeight(40.0);
        shipping.setPrice(345.37);

        assertEquals(Integer.valueOf(3597), product.getPrice());
        assertEquals(Integer.valueOf(4000), product.getWeight());
        assertEquals(Integer.valueOf(34537), shipping.getPrice());

        product.setPrice(35.9713405);
        product.setWeight(40.00756);
        shipping.setPrice(345.37589);

        assertEquals(Integer.valueOf(3597), product.getPrice());
        assertEquals(Integer.valueOf(4000), product.getWeight());
        assertEquals(Integer.valueOf(34537), shipping.getPrice());
    }

    @Test
    public void whenPassingDouble_thenSaveSameValue() {

        Product product = new Product();
        Shipping shipping = new Shipping();

        product.setPrice(3597);
        product.setWeight(4000);
        shipping.setPrice(34537);

        assertEquals(Integer.valueOf(3597), product.getPrice());
        assertEquals(Integer.valueOf(4000), product.getWeight());
        assertEquals(Integer.valueOf(34537), shipping.getPrice());
    }
    
}