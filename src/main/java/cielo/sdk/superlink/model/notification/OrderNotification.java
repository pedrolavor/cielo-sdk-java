package cielo.sdk.superlink.model.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderNotification {
    
    @JsonProperty("order_number")
    private String orderNumber;

    private Integer amount;
    
    @JsonProperty("discount_amount")
    private Integer discountAmount;
    
    @JsonProperty("checkout_cielo_order_number")
    private String checkoutCieloOrderNumber;
    
    @JsonProperty("created_date")
    private String createdDate;
    
    @JsonProperty("customer_name")
    private String customerName;
    
    @JsonProperty("customer_phone")
    private String customerPhone;
    
    @JsonProperty("customer_identity")
    private String customerIdentity;
    
    @JsonProperty("customer_email")
    private String customerEmail;
    
    @JsonProperty("shipping_type")
    private Integer shippingType;
    
    @JsonProperty("shipping_name")
    private String shippingName;
    
    @JsonProperty("shipping_price")
    private Integer shippingPrice;
    
    @JsonProperty("shipping_address_zipcode")
    private String shippingAddressZipcode;
    
    @JsonProperty("shipping_address_district")
    private String shippingAddressDistrict;
    
    @JsonProperty("shipping_address_city")
    private String shippingAddressCity;
    
    @JsonProperty("shipping_address_state")
    private String shippingAddressState;
    
    @JsonProperty("shipping_address_line1")
    private String shippingAddressLine1;
    
    @JsonProperty("shipping_address_line2")
    private String shippingAddressLine2;
    
    @JsonProperty("shipping_address_number")
    private Integer shippingAddressNumber;
    
    @JsonProperty("payment_method_type")
    private Integer paymentMethodType;
    
    @JsonProperty("payment_method_brand")
    private Integer paymentMethodBrand;
    
    private String brand;
    
    @JsonProperty("payment_maskedcreditcard")
    private String paymentMaskedCreditCard;
    
    @JsonProperty("payment_installments")
    private Integer paymentInstallments;
    
    @JsonProperty("payment_status")
    private Integer paymentStatus;
    
    private String tid;
    
    @JsonProperty("test_transaction")
    private String testTransaction;
    
    @JsonProperty("product_id")
    private String productId;
    
    @JsonProperty("product_type")
    private Integer productType;
    
    @JsonProperty("product_sku")
    private String productSku;
    
    @JsonProperty("product_expiration_date")
    private String productExpirationDate;
    
    @JsonProperty("product_quantity")
    private Integer productQuantity;
    
    @JsonProperty("product_description")
    private String productDescription;

    @AllArgsConstructor
    @Getter
    public enum Bank {

        BANCO_BRASIL(1, "Banco do Brasil"),
        BRADESCO(2, "Bradesco");

        private int code;
        private String name;
    }
    
}