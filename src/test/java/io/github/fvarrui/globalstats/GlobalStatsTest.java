package io.github.fvarrui.globalstats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import io.github.fvarrui.globalstats.model.Rank;
import io.github.fvarrui.globalstats.model.Stats;
import io.github.fvarrui.globalstats.model.Section;

public class GlobalStatsTest {
	
	private static final String CLIENT_ID = "RQlOcbRK2xc4L1pAroHimRESIX187mVYdhNpsFav";
	private static final String CLIENT_SECRET = "nAYoZyQog8L8MDQKEYS1TRfaEFDkP8xcIvAI3q6k";
	private static final String KEY = "score";
	
	private String id;
	private GlobalStats client;
	
	@Before
	public void setup() {
	
		id = "63d69c3b5f5e88df0c8b456c";
		client = new GlobalStats(CLIENT_ID, CLIENT_SECRET);
		
	}

	@Test
	public void getAccessTokenTest() throws Exception {
		
		System.out.println("-----> getAccessTokenTest:");
		
		String token = client.getAccessToken();
		
		System.out.println(token);
		
		assertNotNull(token);
		
	}
	
	@Test
	@SuppressWarnings("serial")
	public void createStatsTest() throws Exception {
		
		System.out.println("-----> createStatsTest:");

		String name = "user" + UUID.randomUUID().toString();
		
		Stats stats = client.createStats(name, new HashMap<String, Object>() {{
			put(KEY, 100);
		}});
		
		System.out.println(stats);
		
		assertNotNull(stats.getId());
		assertEquals(stats.getName(), name);
		assertTrue(
				stats.getValues().stream()
					.filter(value -> value.getKey().equals(KEY))
					.anyMatch(value -> value.getValue() == 100)
		);
		
	}
	
	@Test
	@SuppressWarnings("serial")
	public void updateStatsTest() throws Exception {
		
		System.out.println("-----> updateStatsTest:");
		
		Stats stats = client.updateStats(id, new HashMap<String, Object>() {{
			put(KEY, "20");			
		}});
		
		System.out.println(stats);
		
		assertEquals(id, stats.getId());
		
	}
	
	@Test
	public void getStatsTest() throws Exception {

		System.out.println("-----> getStatsTest:");
		
		Stats stats = client.getStats(id);
		
		System.out.println(stats);
		
		assertEquals(id, stats.getId());
		assertTrue(!stats.getValues().isEmpty());

	}
	
	@Test
	public void getSectionTest() throws Exception {

		System.out.println("-----> getSectionTest:");
		
		Section section = client.getStatsSection(id, "scoree");
		
		System.out.println(section);
		
	}
	
	@Test
	public void getLeaderboardTest() throws Exception {

		System.out.println("-----> getLeaderboardTest:");
		
		List<Rank> ranks = client.getLeaderboard("score", 10);
		
		System.out.println(ranks);
		
	}

}
