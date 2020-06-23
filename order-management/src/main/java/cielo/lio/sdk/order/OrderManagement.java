package cielo.lio.sdk.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cielo.lio.sdk.Environment;
import cielo.lio.sdk.order.request.CieloError;
import cielo.lio.sdk.order.request.CieloLioFilter;
import cielo.lio.sdk.order.request.CieloRequestException;

public class OrderManagement {
	private Environment environment;
	private String clientId;
	private String accessToken;
	private String merchantId;

	public OrderManagement(String clientId, String merchantId, String accessToken) {
		this(clientId, merchantId, accessToken, cielo.lio.sdk.order.Environment.PRODUCTION);
	}

	public OrderManagement(String clientId, String merchantId, String accessToken, Environment environment) {
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.accessToken = accessToken;
		this.environment = environment;
	}

	public Order createOrder(Order order) throws CieloRequestException, IOException {
		String url = environment.getUrl() + "/orders";

		HttpPost request = new HttpPost(url);
		String entity = new GsonBuilder().setPrettyPrinting().create().toJson(order);

		request.setEntity(new StringEntity(entity));

		String response = sendRequest(request);
		Gson gson = new Gson();

		return gson.fromJson(response, Order.class);
	}

	public void cancelOrder(String id) throws IOException, CieloRequestException {
		updateOrder(id, "CANCEL");
	}

	public void payOrder(String id) throws IOException, CieloRequestException {
		updateOrder(id, "PAY");
	}

	public void placeOrder(String id) throws IOException, CieloRequestException {
		updateOrder(id, "PLACE");
	}

	public void closeOrder(String id) throws IOException, CieloRequestException {
		updateOrder(id, "CLOSE");
	}

	public List<Order> getOrders() throws IOException, CieloRequestException {
		return getOrders(null);
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrders(CieloLioFilter filtro) throws IOException, CieloRequestException {

		String query = "";
		if(filtro != null) {
			if(filtro.getPageSize() != null) query += ("&page_size=" + filtro.getPageSize());
			if(filtro.getPage() != null) query += ("&page=" + filtro.getPage());
			if(filtro.getStatus() != null) query += ("&status=" + filtro.getStatus());
			if(filtro.getNumber() != null) query += ("&number=" + filtro.getNumber());
			if(filtro.getMerchantId() != null) query += ("&merchant_id=" + filtro.getMerchantId());
			if(filtro.getReference() != null) query += ("&reference=" + filtro.getReference());
			if(filtro.getTerminalNumber() != null) query += ("&terminal_number=" + filtro.getTerminalNumber());
			if(filtro.getLastQueryDate() != null) query += ("&last_query_date=" + filtro.getLastQueryDate());
			query = query.replaceFirst("&", "?");
		}

		String url = environment.getUrl() + "/orders" + query;

		System.out.println(url);

		HttpGet request = new HttpGet(url);
		String response = sendRequest(request);
		Gson gson = new Gson();

		return gson.fromJson(response, List.class);
	}

	public String getOrdersString() throws IOException, CieloRequestException {
		String url = environment.getUrl() + "/orders";

		HttpGet request = new HttpGet(url);

		String response = sendRequest(request);

		return response;
	}

	public Order getOrder(String id) throws IOException, CieloRequestException {
		String url = environment.getUrl() + "/orders/" + id;

		HttpGet request = new HttpGet(url);

		String response = sendRequest(request);
		Gson gson = new Gson();

		return gson.fromJson(response, Order.class);
	}

	public void deleteOrder(String id) throws IOException, CieloRequestException {
		String url = environment.getUrl() + "/orders/" + id;

		HttpDelete request = new HttpDelete(url);

		sendRequest(request);
	}

	public OrderItem addOrderItem(String orderId, OrderItem orderItem) throws CieloRequestException, IOException {
		String url = environment.getUrl() + "/orders/" + orderId + "/items";

		HttpPost request = new HttpPost(url);
		String entity = new GsonBuilder().setPrettyPrinting().create().toJson(orderItem);

		request.setEntity(new StringEntity(entity));

		String response = sendRequest(request);
		Gson gson = new Gson();

		return gson.fromJson(response, OrderItem.class);
	}

	public OrderItem editOrderItem(String orderId, OrderItem orderItem) throws CieloRequestException, IOException {
		String url = environment.getUrl() + "/orders/" + orderId + "/items/" + orderItem.getId();

		HttpPut request = new HttpPut(url);
		String entity = new GsonBuilder().setPrettyPrinting().create().toJson(orderItem);

		request.setEntity(new StringEntity(entity));

		String response = sendRequest(request);
		Gson gson = new Gson();

		return gson.fromJson(response, OrderItem.class);
	}

	public void deleteOrderItem(String orderId, String orderItemId) throws CieloRequestException, IOException {
		String url = environment.getUrl() + "/orders/" + orderId + "/items/" + orderItemId;

		HttpDelete request = new HttpDelete(url);

		sendRequest(request);
	}

	public OrderItem[] getOrderItems(String orderId) throws CieloRequestException, IOException {
		String url = environment.getUrl() + "/orders/" + orderId + "/items";

		HttpGet request = new HttpGet(url);

		String response = sendRequest(request);
		Gson gson = new Gson();

		return gson.fromJson(response, OrderItem[].class);
	}

	public Transaction[] getOrderTransactions(String orderId) throws CieloRequestException, IOException {
		String url = environment.getUrl() + "/orders/" + orderId + "/transactions";

		HttpGet request = new HttpGet(url);

		String response = sendRequest(request);
		Gson gson = new Gson();

		return gson.fromJson(response, Transaction[].class);
	}

	String readResponse(HttpResponse response) throws IOException, CieloRequestException {
		HttpEntity responseEntity = response.getEntity();
		InputStream responseEntityContent = responseEntity.getContent();

		Header contentEncoding = response.getFirstHeader("Content-Encoding");

		if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
			responseEntityContent = new GZIPInputStream(responseEntityContent);
		}

		BufferedReader responseReader = new BufferedReader(new InputStreamReader(responseEntityContent));
		StringBuilder responseBuilder = new StringBuilder();
		String line;

		while ((line = responseReader.readLine()) != null) {
			responseBuilder.append(line);
		}

		int statusCode = response.getStatusLine().getStatusCode();
		String responseBody = responseBuilder.toString();

		if (statusCode >= 400 && statusCode < 500) {
			CieloRequestException exception = null;

			if (statusCode == 404) {
				exception = new CieloRequestException("Not found", new CieloError(404, "Not found", ""), exception);
			} else {
				System.out.println(statusCode);
				System.out.println(responseBody);
				CieloError error = new Gson().fromJson(responseBody, CieloError.class);

				exception = new CieloRequestException(error.getDetail(), error, exception);
			}

			throw exception;
		}

		System.out.println(responseBody);

		return responseBody;
	}

	String sendRequest(HttpUriRequest request) throws IOException, CieloRequestException {
		HttpClient client = HttpClientBuilder.create().build();

		request.addHeader("Accept", "application/json");
		request.addHeader("Accept-Encoding", "gzip");
		request.addHeader("Content-Type", "application/json");
		request.addHeader("User-Agent", "Cielo-Lio SDK");

		request.addHeader("client-id", clientId);
		request.addHeader("merchant-id", merchantId);
		request.addHeader("access-token", accessToken);

		HttpResponse response = client.execute(request);

		return readResponse(response);
	}

	void updateOrder(String id, String operation) throws IOException, CieloRequestException {
		String url = environment.getUrl() + "/orders/" + id + "?operation=" + operation;

		HttpPut request = new HttpPut(url);

		sendRequest(request);
	}
}