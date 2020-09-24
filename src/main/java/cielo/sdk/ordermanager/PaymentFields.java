package cielo.sdk.ordermanager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentFields {
	
	private String pan;

	private Integer v40Code;

	private String typeName;

	private String cityState;

	private String clientName;

	private Integer serviceTax;

	private Integer statusCode;

	private Integer boardingTax;

	private Boolean hasPassword;

	private Boolean hasWarranty;

	private String productName;

	private Long requestDate;

	private Integer changeAmount;

	private String documentType;

	private String entranceMode;

	private Boolean hasSignature;

	private String merchantCode;

	private String merchantName;

	private String applicationId;

	private Integer totalizerCode;

	private Integer upFrontAmount;

	private Integer credtAdminTax;

	private Integer firstQuotaDate;

	private Integer interestAmount;

	private Boolean isExternalCall;

	private String applicationName;

	private Integer avaiableBalance;

	private Integer cardCaptureType;

	private String finalCryptogram;

	private Boolean hasConnectivity;

	private String merchantAddress;

	private Integer paymentTypeCode;

	private Integer firstQuotaAmount;

	private Boolean hasSentReference;

	private Boolean isFinancialProduto;

	private Integer primaryProductCode;

	private Boolean hasSentMerchantCode;

	private String cardLabelApplication;

	private String paymentTransactionId;

	private Integer secondaryProductCode;

	private String originalTransactionId;

	private Integer receiptPrintPermission;

	private Boolean hasPrintedClientReceipt;

	private Boolean isDoubleFontPrintAllowed;

	private Boolean isOnlyIntegrationCancelable;

	private String primaryProductName;
	
	private String secondaryProductName;
	
	private int numberOfQuotas;

}
