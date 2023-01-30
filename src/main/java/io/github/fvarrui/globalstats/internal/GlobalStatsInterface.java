package io.github.fvarrui.globalstats.internal;

import java.util.List;
import java.util.Map;

import io.github.fvarrui.globalstats.internal.model.AccessToken;
import io.github.fvarrui.globalstats.internal.model.SectionResults;
import io.github.fvarrui.globalstats.internal.model.StatsQuery;
import io.github.fvarrui.globalstats.model.Achievement;
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
			@Body StatsQuery query
	);
	
	@PUT("v1/statistics/{id}")
	public Call<Stats> updateStats(
			@Header("Authorization") String token,
			@Path("id") String userId,
			@Body StatsQuery query
	);
	
	@GET("v1/statistics/{id}")
	public Call<Stats> getStats(
			@Header("Authorization") String token,
			@Path("id") String userId
	);
	
	@GET("v1/statistics/{id}/section/{key}")
	public Call<SectionResults> getSection(
			@Header("Authorization") String token,
			@Path("id") String userId,		
			@Path("key") String gtdKey		
	);
	
	@POST("v1/gtdleaderboard/{key}")
	public Call<Map<String, List<Rank>>> getLeaderboard(
			@Header("Authorization") String token,
			@Path("key") String gtdKey,		
			@Body Map<String, Object> query
	);
	
	@GET("v1/achievements")
	public Call<Map<String, List<Achievement>>> getAllAchievements(
			@Header("Authorization") String token	
	);
	
	@GET("v1/statistics/{id}/achievements/{achievement}/accomplish")
	public Call<Map<String, Achievement>> accomplish(
			@Header("Authorization") String token,
			@Path("id") String userId,		
			@Path("achievement") String achievement	
	);
	
	@GET("v1/statistics/{id}/achievements")
	public Call<Map<String, List<Achievement>>> getUserAchievements(
			@Header("Authorization") String token,
			@Path("id") String userId
	);

}
