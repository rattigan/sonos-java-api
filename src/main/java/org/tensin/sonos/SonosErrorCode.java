package org.tensin.sonos;

public enum SonosErrorCode {

	UNKNOWN(-1, "Unkown Error Code - Help by updating SonosErrorCode enum"),
	E701(701, "Invalid State");

	private String errorString;
	private int errorNo;
	private int originalErrorNo;

	SonosErrorCode(int errorNo, String errorString) {
		this.errorNo = errorNo;
		this.errorString = errorString;
	}

	static public SonosErrorCode getErrorCode(int errorNo) {

		SonosErrorCode result = UNKNOWN;
		result.originalErrorNo = errorNo;

		for (SonosErrorCode code : values()) {
			if (code.errorNo == errorNo) {
				result = code;
				break;
			}
		}
		return result;

	}

	public String getErrorString() {
		return "" + (this == UNKNOWN ? this.originalErrorNo : this.errorNo) + ":" + errorString;
	}

}
