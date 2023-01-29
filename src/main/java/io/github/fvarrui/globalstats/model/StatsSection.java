package io.github.fvarrui.globalstats.model;

import java.util.ArrayList;
import java.util.List;

public class StatsSection {

	private Rank userRank;
	private List<Rank> ranks = new ArrayList<>();

	public StatsSection(Rank userRank, List<Rank> betterRanks, List<Rank> worseRanks) {
		super();
		this.userRank = userRank;
		this.ranks.addAll(betterRanks);
		this.ranks.add(userRank);
		this.ranks.addAll(worseRanks);
	}

	public Rank getUserRank() {
		return userRank;
	}

	public void setUserRank(Rank userRank) {
		this.userRank = userRank;
	}

	@Override
	public String toString() {
		return "StatsSection [userRank=" + userRank + ", ranks=" + ranks + "]";
	}

}
