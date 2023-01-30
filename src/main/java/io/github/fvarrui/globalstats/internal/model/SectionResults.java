package io.github.fvarrui.globalstats.internal.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.fvarrui.globalstats.model.Rank;

public class SectionResults {

	@SerializedName("user_rank")
	@Expose
	private Rank userRank;

	@SerializedName("better_ranks")
	@Expose
	private Map<String, List<Rank>> betterRanks;

	@SerializedName("worse_ranks")
	@Expose
	private Map<String, List<Rank>> worseRanks;

	public Rank getUserRank() {
		return userRank;
	}

	public void setUserRank(Rank userRank) {
		this.userRank = userRank;
	}

	public Map<String, List<Rank>> getBetterRanks() {
		return betterRanks;
	}

	public void setBetterRanks(Map<String, List<Rank>> betterRanks) {
		this.betterRanks = betterRanks;
	}

	public Map<String, List<Rank>> getWorseRanks() {
		return worseRanks;
	}

	public void setWorseRanks(Map<String, List<Rank>> worseRanks) {
		this.worseRanks = worseRanks;
	}

	@Override
	public String toString() {
		return "SectionResults [userRank=" + userRank + ", betterRanks=" + betterRanks + ", worseRanks=" + worseRanks
				+ "]";
	}

}
