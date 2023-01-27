package io.github.fvarrui.globalstats;

import java.util.HashMap;

import io.github.fvarrui.globalstats.model.Stats;

public class GlobalStatsTest {
	
	private static GlobalStatsClient client = new GlobalStatsClient();

	public static void main(String[] args) throws Exception {
//		getAccessTokenTest();
		createStatsTest();
	}
	
	public static void getAccessTokenTest() throws Exception {
		String token = client.getAccessToken("RQlOcbRK2xc4L1pAroHimRESIX187mVYdhNpsFav", "nAYoZyQog8L8MDQKEYS1TRfaEFDkP8xcIvAI3q6k");
		System.out.println(token);
	}
	
	@SuppressWarnings("serial")
	public static void createStatsTest() throws Exception {
		String token = client.getAccessToken("RQlOcbRK2xc4L1pAroHimRESIX187mVYdhNpsFav", "nAYoZyQog8L8MDQKEYS1TRfaEFDkP8xcIvAI3q6k");
		System.out.println("token: " + token);
		Stats stats = client.createStats(token, "test", new HashMap<String, Object>() {{
			put("score", "201");
		}});
		System.out.println(stats);
	}

}
