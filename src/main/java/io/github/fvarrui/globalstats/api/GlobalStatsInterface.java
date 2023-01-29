package io.github.fvarrui.globalstats.api;

import java.util.List;
import java.util.Map;

import io.github.fvarrui.globalstats.internal.AccessToken;
import io.github.fvarrui.globalstats.internal.SectionResults;
import io.github.fvarrui.globalstats.internal.StatsQuery;
import io.github.fvarrui.globalstats.model.Rank;
import io.github.fvarrui.globalstats.model.Stats;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GlobalStatsInterface {
	
	@POST("oauth/access_token")
	@FormUrlEncoded
	public Call<AccessToken> getAccessToken(
			@Field("grant_type") String grantType, 
			@Field("scope") String scope, 
			@Field("client_id") String clientId, 
			@Field("client_secret") String clientSecret
	);
	
	@POST("v1/statistics")
	public Call<Stats> createStats(
			@Header("Authorization") String token,
			@Body StatsQuery stats
	);
	
	@PUT("v1/statistics/{id}")
	public Call<Stats> updateStats(
			@Header("Authorization") String token,
			@Path("id") String id,
			@Body StatsQuery stats
	);
	
	@GET("v1/statistics/{id}")
	public Call<Stats> getStats(
			@Header("Authorization") String token,
			@Path("id") String id
	);
	
	@GET("v1/statistics/{id}/section/{key}")
	public Call<SectionResults> getSection(
			@Header("Authorization") String token,
			@Path("id") String id,		
			@Path("key") String key		
	);
	
	@POST("v1/gtdleaderboard/{key}")
	public Call<Map<String, List<Rank>>> getLeaderboard(
			@Header("Authorization") String token,
			@Path("key") String key,		
			@Body Map<String, Object> query
	);
	

}
