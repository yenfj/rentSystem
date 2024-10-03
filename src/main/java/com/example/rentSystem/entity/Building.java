package com.example.rentSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/*
 * 建物情報テーブル
 * 作成者：顔
 * 作成日：2024/09/26
 * 更新日：2024/09/26
 * 新規追加
 */
@Entity
@Table(name = "building")
public class Building {
	
	// 建物Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "building_id")
	private int buildingId;

	// 建物名称
	@NotBlank(message = "Building name cannot be empty.")
	@Column(name = "building_name")
	private String buildingName;

	// 所在地
	@NotBlank(message = "Building address cannot be empty.")
	@Column(name = "address")
	private String address;

	// 建物種類
	@NotBlank(message = "Building type cannot be empty.")
	@Column(name = "type")
	private String type;

	// 建物構造
	@Column(name = "structure")
	private String structure;

	// 建築時期年
	@Column(name = "period_year")
	private int periodYear;

	// 建築時期月
	@Column(name = "period_month")
	private int periodMonth;

	// 大規模修繕年
	@Column(name = "repair_year")
	private int repairYear;

	// 大規模修繕月
	@Column(name = "repair_month")
	private int repairMonth;

	public Building() {
		super();
	}

	public Building(String buildingName, String address, String type, String structure, int periodYear,
			int periodMonth, int repairYear, int repairMonth) {
		super();
		this.buildingName = buildingName;
		this.address = address;
		this.type = type;
		this.structure = structure;
		this.periodYear = periodYear;
		this.periodMonth = periodMonth;
		this.repairYear = repairYear;
		this.repairMonth = repairMonth;
	}

	// getterとsetter
	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public String getAddress() {
		return address;
	}

	public String getType() {
		return type;
	}

	public String getStructure() {
		return structure;
	}

	public int getPeriodYear() {
		return periodYear;
	}

	public int getPeriodMonth() {
		return periodMonth;
	}

	public int getRepairYear() {
		return repairYear;
	}

	public int getRepairMonth() {
		return repairMonth;
	}
}
