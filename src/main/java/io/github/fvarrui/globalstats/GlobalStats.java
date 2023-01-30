package io.github.fvarrui.globalstats;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.fvarrui.globalstats.adapters.LocalDateTimeAdapter;
import io.github.fvarrui.globalstats.internal.GlobalStatsInterface;
import io.github.fvarrui.globalstats.internal.model.AccessToken;
import io.github.fvarrui.globalstats.internal.model.SectionResults;
import io.github.fvarrui.globalstats.internal.model.StatsQuery;
import io.github.fvarrui.globalstats.model.Achievement;
import io.github.fvarrui.globalstats.model.Error;
import io.github.fvarrui.globalstats.model.Rank;
import io.github.fvarrui.globalstats.model.Stats;
import io.github.fvarrui.globalstats.model.Section;
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
			Error error = gson.fromJson(response.errorBody().string(), Error.class);
			throw new GlobalStatsException(error);
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
	
	public Section getStatsSection(String id, String key) throws Exception {
		Response<SectionResults> response = service.getSection(
			"Bearer " + getAccessToken(),
			id,
			key
		).execute();
		assertResponse(response);
		SectionResults results = response.body();
		return new Section(results.getUserRank(), results.getBetterRanks().get("data"), results.getWorseRanks().get("data"));
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
		return response.body().get("data");
	}
	
	public List<Achievement> getAllAchievements() throws Exception {
		Response<Map<String, List<Achievement>>> response = service.getAllAchievements(
			"Bearer " + getAccessToken()
		).execute();
		assertResponse(response);
		response.body();
		return response.body().get("achievements");
	}

	public Achievement accomplish(String id, String achievement) throws Exception {
		Response<Map<String, Achievement>> response = service.accomplish(
			"Bearer " + getAccessToken(),
			id,
			achievement
		).execute();
		assertResponse(response);
		response.body();
		return response.body().get("achievement");
	}

	public List<Achievement> getUserAchievements(String id) throws Exception {
		Response<Map<String, List<Achievement>>> response = service.getAllAchievements(
			"Bearer " + getAccessToken()
		).execute();
		assertResponse(response);
		response.body();
		return response.body().get("achievements");
	}
	
}
