package io.github.fvarrui.globalstats.internal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.fvarrui.globalstats.model.Rank;

public class SectionResults {

	@SerializedName("user_rank")
	@Expose
	private Rank userRank;

	@SerializedName("better_ranks")
	@Expose
	private Ranks betterRanks;

	@SerializedName("worse_ranks")
	@Expose
	private Ranks worseRanks;

	public Rank getUserRank() {
		return userRank;
	}

	public void setUserRank(Rank userRank) {
		this.userRank = userRank;
	}

	public Ranks getBetterRanks() {
		return betterRanks;
	}

	public void setBetterRanks(Ranks betterRanks) {
		this.betterRanks = betterRanks;
	}

	public Ranks getWorseRanks() {
		return worseRanks;
	}

	public void setWorseRanks(Ranks worseRanks) {
		this.worseRanks = worseRanks;
	}

	@Override
	public String toString() {
		return "Section [userRank=" + userRank + ", betterRanks=" + betterRanks + ", worseRanks=" + worseRanks + "]";
	}

}
