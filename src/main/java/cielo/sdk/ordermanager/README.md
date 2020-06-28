# Cielo Lio Order Manager

SDK para integração com o Cielo Order Manager (Cielo LIO).

## Configuração do Order Management

```java
	OrderManagement orderManagement =
		new OrderManagement("client_id", "merchant_id", "access_token", Environment.SANDBOX);
```

## Criação de um Order

```java
    OrderItem item = OrderItem.builder()
        .sku("1234567890123")
        .name("Nome do item")
        .unitPrice(5000)
        .quantity(2)
        .unitOfMeasure(OrderItem.UnitOfMeasure.EACH)
        .build();

    Order order = Order.builder()
        .number("123456")
        .reference("Order 123456")
        .notes("Order from customer Jack Miller on table 10")
        .price(10000)
        .status(Order.Status.DRAFT)
        .items(Arrays.asList(item))
        .build();

try {
    order = orderManagement.createOrder(order);
} catch (IOException e) {
    // ...
} catch (CieloRequestException e) {
    e.printStackTrace();
}
```

## Consultar um Order

```java
try {
	orderManagement.getOrder("de305d54-75b4-431b-adb2-eb6b9e546014");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (CieloRequestException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
```

## Listar Orders

```java
try {
	CieloLioFilter filtro = CieloLioFilter.builder()
		.status(Order.Status.PAID)
		.pageSize(5)
		.page(3)
		.build();
	
	List<Order> orders = orderManagement.getOrders(filtro);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (CieloRequestException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
```

## Liberando um Order para pagamento

```java
try {
	orderManagement.placeOrder("de305d54-75b4-431b-adb2-eb6b9e546014");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (CieloRequestException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
```

## Fechar um Order

```java
try {
	orderManagement.closeOrder("de305d54-75b4-431b-adb2-eb6b9e546014");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (CieloRequestException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
```

## Excluir um Order

```java
try {
	orderManagement.deleteOrder("de305d54-75b4-431b-adb2-eb6b9e546014");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (CieloRequestException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
```