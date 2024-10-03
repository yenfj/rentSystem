package com.example.rentSystem.vo;

import java.time.LocalDate;

/*
 * 作成者：顔
 * 作成日：2024/09/19
 * 更新日：2024/10/03
 * 契約の検索条件に満たしたデータを返す
 */
public class SearchContractRes {
	
	// 契約Id
	private int contractId;
	
	// 建物名称
	private String buildingName;
	
	// 住戸番号
	private int roomId;
	
	// 貸主名
	private String owner;
	
	// 借主名
	private String tenant;
	
	// 契約始期
	private LocalDate startDate;
	
	// 契約終期
	private LocalDate endDate;
	
	// 契約状態
	private int state;

	public SearchContractRes() {
		super();
	}

	public SearchContractRes(int contractId, String buildingName, int roomId, String owner, String tenant,
			LocalDate startDate, LocalDate endDate) {
		super();
		this.contractId = contractId;
		this.buildingName = buildingName;
		this.roomId = roomId;
		this.owner = owner;
		this.tenant = tenant;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// getterとsetter
	public int getContractId() {
		return contractId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public int getRoomId() {
		return roomId;
	}

	public String getOwner() {
		return owner;
	}

	public String getTenant() {
		return tenant;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
