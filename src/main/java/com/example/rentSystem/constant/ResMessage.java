package com.example.rentSystem.constant;

public enum ResMessage {
	
	SUCCESS(200, "success"), //
	CONTRACT_DATE_ERROR(400, "start date cannnot be later than end date"),; //
	
	private int code;
	
	private String mesage;

	private ResMessage(int code, String mesage) {
		this.code = code;
		this.mesage = mesage;
	}

	public int getCode() {
		return code;
	}

	public String getMesage() {
		return mesage;
	}

}
