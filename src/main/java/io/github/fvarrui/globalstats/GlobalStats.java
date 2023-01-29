package io.github.fvarrui.globalstats;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.fvarrui.globalstats.adapters.LocalDateTimeAdapter;
import io.github.fvarrui.globalstats.api.GlobalStatsInterface;
import io.github.fvarrui.globalstats.internal.AccessToken;
import io.github.fvarrui.globalstats.internal.SectionResults;
import io.github.fvarrui.globalstats.internal.StatsQuery;
import io.github.fvarrui.globalstats.model.GlobalStatsException;
import io.github.fvarrui.globalstats.model.Rank;
import io.github.fvarrui.globalstats.model.Stats;
import io.github.fvarrui.globalstats.model.StatsSection;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalStats {
	
	private static final String BASE_URL = "https://api.globalstats.io/"; 

	private String clientId;
	private String clientSecret;
	private AccessToken token;
	private LocalDateTime tokenExpirationDate;
	private GlobalStatsInterface service;
	private Gson gson;
	
	public GlobalStats(String clientId, String clientSecret) {
		
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		
		gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
				.create();
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
		
		service = retrofit.create(GlobalStatsInterface.class);
		
	}
	
	private void assertResponse(Response<?> response) throws Exception {
		if (!response.isSuccessful()) {
			throw gson.fromJson(response.errorBody().string(), GlobalStatsException.class);
		}
	}
	
	private AccessToken renewAccessToken(String clientId, String clientSecret) throws Exception {		
		Response<AccessToken> response = service.getAccessToken(
			"client_credentials", 
			"endpoint_client", 
			clientId, 
			clientSecret
		).execute();
		assertResponse(response);
		return response.body();
	}
	
	public String getAccessToken() throws Exception {
		if (token == null || LocalDateTime.now().isAfter(tokenExpirationDate)) {
			token = renewAccessToken(clientId, clientSecret);
			tokenExpirationDate = LocalDateTime.now().plusSeconds(token.getExpiresIn());			
		}
		return token.getAccessToken();
	}
	
	public Stats createStats(String name, Map<String, Object> values) throws Exception {
		Response<Stats> response = service.createStats(
			"Bearer " + getAccessToken(), 
			new StatsQuery(name, values)
		).execute();
		assertResponse(response);
		return response.body();
	}
	
	public Stats updateStats(String id, Map<String, Object> values) throws Exception {
		Response<Stats> response = service.updateStats(
			"Bearer " + getAccessToken(),
			id,
			new StatsQuery(values)
		).execute();
		assertResponse(response);
		response.body().setId(id);		
		return response.body();
	}
	
	public Stats getStats(String id) throws Exception {
		Response<Stats> response = service.getStats(
			"Bearer " + getAccessToken(),
			id
		).execute();
		assertResponse(response);
		response.body().setId(id);
		return response.body();
	}
	
	public StatsSection getStatsSection(String id, String key) throws Exception {
		Response<SectionResults> response = service.getSection(
			"Bearer " + getAccessToken(),
			id,
			key
		).execute();
		assertResponse(response);
		SectionResults results = response.body();
		return new StatsSection(results.getUserRank(), results.getBetterRanks().getData(), results.getWorseRanks().getData());
	}
	
	@SuppressWarnings("serial")
	public List<Rank> getLeaderboard(String key, int limit, String ... additionals) throws Exception {
		Map<String, Object> query = new HashMap<String, Object>() {{
			put("limit", limit);
			put("additionals", additionals);
		}};		
		Response<Map<String, List<Rank>>> response = service.getLeaderboard(
			"Bearer " + getAccessToken(),
			key,
			query
		).execute();
		assertResponse(response);
		Map<String, List<Rank>> results = response.body();
		return results.get("data");
	}
	
}
