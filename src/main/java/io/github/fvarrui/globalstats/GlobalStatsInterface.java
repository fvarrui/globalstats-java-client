package io.github.fvarrui.globalstats;

import io.github.fvarrui.globalstats.model.AccessToken;
import io.github.fvarrui.globalstats.model.FirstStats;
import io.github.fvarrui.globalstats.model.Stats;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

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
			@Body FirstStats stats
	);

}
