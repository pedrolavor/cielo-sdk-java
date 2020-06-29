# Cielo Lio Super Link

SDK para integração com o Cielo Super Link.

## Instaciando um SuperLink

```java
	Environment environment = Environment.SANDBOX;

	ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
	resource.setClientId("your_client_id");
	resource.setClientSecret("your_client_secret");
	resource.setAccessTokenUri(environment.getAccessTokenUrl() + "/token");

	OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource);
	SuperLink superLink = new SuperLinkOAuth2RestTemplateImpl(restTemplate, environment);
```

## Criação de um Link

```java
	Product product = Product.builder()
		.type(Product.Type.PAYMENT)
		.name("Nome do Produto")
		.description("Descrição do produto que será exibida na tela de Checkout.")
		.price(10000) // em cenetavos (R$ 100,00 -> 10000)
		.weight(2000) // em gramas (2kg -> 2000g)
		.expirationDate(new Date(2020, 11, 25)) // data de expiração do link
		.maxNumberOfInstallments(12) // número máximo de parcelas
		.quantity(1)
		.sku("1234567890123")
		.shipping(new Shipping("Free Shipping", 0, "6900000", Shipping.Type.FREE))
		.softDescriptor("Descrição a ser apresentada na fatura do cartão.")
		.build();

	product = superLink.createLink(product);

	Srting link = product.getShortLink();
```

## Consultar um Link

```java
	product = superLink.getLink("de305d54-75b4-431b-adb2-eb6b9e546014");
```

## Atualizando um Link

```java
	product.setPrice(20000);
	superLink.updateLink("de305d54-75b4-431b-adb2-eb6b9e546014", product);
```

## Excluindo um Link

```java
	superLink.deleteLink("de305d54-75b4-431b-adb2-eb6b9e546014");
```