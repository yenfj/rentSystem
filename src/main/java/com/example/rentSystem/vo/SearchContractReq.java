package com.example.rentSystem.vo;

import java.time.LocalDate;

/*
 * 作成者：顔
 * 作成日：2024/09/19
 * 更新日：2024/09/19
 * 契約一覧の検索条件
 */
public class SearchContractReq {

	// 契約Id
	private int contractId;
	
	// 建物名称
	private String buildingName;
	
	// 契約始期
	private LocalDate startDate;
	
	// 契約終期
	private LocalDate endDate;
	
	// 貸主名
	private String owner;
	
	// 借主名
	private String tenant;

	public SearchContractReq() {
		super();
	}

	public SearchContractReq(int contractId, String buildingName, LocalDate startDate, LocalDate endDate, String owner,
			String tenant) {
		super();
		this.contractId = contractId;
		this.buildingName = buildingName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.owner = owner;
		this.tenant = tenant;
	}

	// getterとsetter
	public int getContractId() {
		return contractId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getOwner() {
		return owner;
	}

	public String getTenant() {
		return tenant;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
}
