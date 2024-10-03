package com.example.rentSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/*
 * 部屋情報テーブル
 * 作成者：顔
 * 作成日：2024/09/26
 * 更新日：2024/09/26
 * 新規追加
 */
@Entity
@Table(name = "room")
public class Room {
	
	// 部屋Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "room_id")
	private int roomId;
	
	// 建物Id
	@Min(value = 1, message = "Builing id cannot be less than 0.")
	@Column(name = "builing_id")
	private int buildingId;
	
	// 住戸番号
	@Min(value = 1, message = "Room id cannot be less than 0.")
	@Column(name = "room_number")
	private int roomNumber;
	
	// 貸主名
	@NotBlank(message = "Owner cannot be empty.")
	@Column(name = "owner")
	private String owner;
	
	// 間取り
	@Column(name = "floor_plan")
	private String floorPlan;

	// 床面積
	@Column(name = "floor_space")
	private int floorSpace;

	// バルコニー面積
	@Column(name = "balcony_area")
	private int balconyArea;

	// 賃料
	@Column(name = "rent")
	private int rent;

	// 管理費
	@Column(name = "management_fee")
	private int managementFee;

	// 保証金
	@Column(name = "deposit")
	private int deposit;

	// 礼金
	@Column(name = "gift_money")
	private int giftMoney;

	// 部屋現状
	@Column(name = "state")
	private String state;
	
	public Room() {
		super();
	}

	// 新規部屋を追加する用
	public Room(int buildingId, int roomNumber, String owner, String floorPlan, int floorSpace,
			int balconyArea, int rent, int managementFee, int deposit, int giftMoney, String state) {
		super();
		this.buildingId = buildingId;
		this.roomNumber = roomNumber;
		this.owner = owner;
		this.floorPlan = floorPlan;
		this.floorSpace = floorSpace;
		this.balconyArea = balconyArea;
		this.rent = rent;
		this.managementFee = managementFee;
		this.deposit = deposit;
		this.giftMoney = giftMoney;
		this.state = state;
	}
	
	// 部屋情報を更新する用
	public Room(int roomId, int buildingId, int roomNumber, String owner, String floorPlan, int floorSpace,
			int balconyArea, int rent, int managementFee, int deposit, int giftMoney, String state) {
		super();
		this.roomId = roomId;
		this.buildingId = buildingId;
		this.roomNumber = roomNumber;
		this.owner = owner;
		this.floorPlan = floorPlan;
		this.floorSpace = floorSpace;
		this.balconyArea = balconyArea;
		this.rent = rent;
		this.managementFee = managementFee;
		this.deposit = deposit;
		this.giftMoney = giftMoney;
		this.state = state;
	}

	// getterとsetter
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getOwner() {
		return owner;
	}

	public String getFloorPlan() {
		return floorPlan;
	}

	public int getFloorSpace() {
		return floorSpace;
	}

	public int getBalconyArea() {
		return balconyArea;
	}

	public int getRent() {
		return rent;
	}

	public int getManagementFee() {
		return managementFee;
	}

	public int getDeposit() {
		return deposit;
	}

	public int getGiftMoney() {
		return giftMoney;
	}

	public String getState() {
		return state;
	}
}
