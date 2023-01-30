package io.github.fvarrui.globalstats;

import io.github.fvarrui.globalstats.model.Error;

public class GlobalStatsException extends Exception {
	private static final long serialVersionUID = -4546541580805813125L;
	
	private Error error;
	
	public GlobalStatsException(Error error) {
		super(error.toString());
		this.error = error;
	}
	
	public Error getError() {
		return error;
	}

}
