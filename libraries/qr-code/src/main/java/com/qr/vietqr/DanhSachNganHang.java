package com.qr.vietqr;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.json.JSONArray;
import org.json.JSONObject;

public class DanhSachNganHang {

	private static final String SAMPLE_URL = "https://api.vietqr.io/v2/banks";

	public static void main(String[] args) throws IOException, ParseException {
		final HttpGet httpPost = new HttpGet(SAMPLE_URL);

//		httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
//		httpPost.setHeader("x-client-id", "ea051f23-0090-4eea-b276-bfc7fdebd4db");
//		httpPost.setHeader("x-api-key", "e97a6eb8-eed5-471d-8e63-ab4f396b7862");

//		Map<String, String> params = Map.of( //
//			"acqId", "970424", //
//			"amount", "123456", // Tong so tien thanh toan
//			"addInfo", "Thong tin chuyen khoan", // Thong tin chuyen khoan
//			"format", "text", //
//			"template", "compact2", //
//			"accountNo", "113366668888", //
//			"accountName", "QUY VAC XIN PHONG CHONG COVID" //
//		);

//		String jsonPayload = new ObjectMapper().writeValueAsString(params);
//		httpPost.setEntity(new StringEntity(jsonPayload, ContentType.APPLICATION_JSON));

		try ( //
			CloseableHttpClient client = HttpClients.createDefault();
			ClassicHttpResponse response = client.execute(httpPost, new BasicHttpContext()); //
			// ClassicHttpResponse response = client.execute(httpPost, new HttpClientContext()); //
		) {
			// Get the response body
			HttpEntity responseEntity = response.getEntity();
			String responseBody = EntityUtils.toString(responseEntity);

			// Close the response entity
			EntityUtils.consume(responseEntity);

			// Handle the response
			System.out.println("Response Code: " + response.getCode());
			System.out.println("Response Body: " + responseBody);
			
			 JSONObject jsonObj = new JSONObject(responseBody);
			 JSONArray arr = new JSONArray(jsonObj.get("data").toString());
			 System.out.println(arr.get(2));
			
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode node = mapper.readTree(responseBody);
//			System.out.println(node.get("data").asText());
		}
	}

}
