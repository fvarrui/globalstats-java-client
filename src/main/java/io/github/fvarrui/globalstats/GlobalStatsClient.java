package io.github.fvarrui.globalstats;

import java.io.IOException;
import java.util.Map;

import io.github.fvarrui.globalstats.model.AccessToken;
import io.github.fvarrui.globalstats.model.FirstStats;
import io.github.fvarrui.globalstats.model.Stats;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalStatsClient {
	
	private static final String BASE_URL = "https://api.globalstats.io/"; 

	private GlobalStatsInterface service;
	
	public GlobalStatsClient() {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(GlobalStatsInterface.class);
		
	}
	
	private void assertResponse(Response<?> response) throws IOException, Exception {
		if (!response.isSuccessful()) {
			throw new Exception(response.errorBody().string());
		}		
	}
	
	public String getAccessToken(String clientId, String clientSecret) throws Exception {		
		Response<AccessToken> response = service.getAccessToken("client_credentials", "endpoint_client", clientId, clientSecret).execute();
		assertResponse(response);
		return response.body().getAccessToken();
	}
	
	public Stats createStats(String token, String name, Map<String, Object> values) throws IOException, Exception {
		FirstStats first = new FirstStats(name, values);
		Response<Stats> response = service.createStats("Bearer " + token, first).execute();
		assertResponse(response);
		return response.body();
	}	
	
}
