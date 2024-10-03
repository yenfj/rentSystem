package com.example.rentSystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * 契約テーブル
 * 作成者：顔
 * 作成日：2024/09/19
 * 更新日：2024/09/26
 * 契約のDBが更新されて、フィールド名を更新する
 */
@Entity
@Table(name = "contract")
public class Contract {
	
	// 契約Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "contract_id")
	private int contractId;
	
	// 部屋Id
	@Min(value = 1, message = "Room id cannot be less than 0.")
	@Column(name = "room_id")
	private int roomId;
	
	// 貸主名
	@NotBlank(message = "Owner cannot be empty.")
	@Column(name = "owner")
	private String owner;
	
	// 借主名
	@NotBlank(message = "Tenant cannot be empty.")
	@Column(name = "tenant")
	private String tenant;

	// 契約始期
	@NotNull(message = "Start date cannot be null.")
	@Column(name = "start_date")
	private LocalDate startDate;

	// 契約終期
	@NotNull(message = "End date cannot be null.")
	@Column(name = "end_date")
	private LocalDate endDate;

	// 引き渡し日
	@NotNull(message = "Deliver date cannot be null.")
	@Column(name = "deliver_date")
	private LocalDate deliverDate;

	// 賃料
	@Min(value = 1, message = "Rent cannot be less than 0.")
	@Column(name = "rent")
	private int rent;

	// 賃料の支払時期
	@Column(name = "rent_payment_term")
	private String rentPaymentTerm;

	// 賃料の支払期限
	@Column(name = "rent_deadline")
	private int rentDeadline;

	// 管理費
	@Column(name = "management_fee")
	private int managementFee;

	// 管理費の支払時期
	@Column(name = "management_fee_payment_term")
	private String managementFeePaymentTerm;

	// 管理費の支払期限
	@Column(name = "management_fee_deadline")
	private int managementFeeDeadline;

	// 保証金
	@Column(name = "deposit")
	private int deposit;

	// 駐車場使用料
	@Column(name = "parking_fee")
	private int parkingFee;

	// 付属施設使用料
	@Column(name = "facilities_fee")
	private int facilitiesFee;

	// 礼金
	@Column(name = "gift_money")
	private int giftMoney;

	// 支払い方法
	@NotBlank(message = "Payment method cannot be empty.")
	@Column(name = "payment_method")
	private String paymentMethod;

	// 振込手数料負担者
	@Column(name = "handing_fee")
	private String handingFee;

	// 口座名義人
	@Column(name = "account_name")
	private String accountName;

	// 銀行金融機関名
	@Column(name = "bank_name")
	private String bankName;

	// 口座種別
	@Column(name = "account_type")
	private String accountType;

	// 口座番号
	@Column(name = "account")
	private String account;

	// 持ち参り先
	@Column(name = "document_address")
	private String documentAddress;

	// 備考
	@Column(name = "remarks")
	private String remarks;

	public Contract() {
		super();
	}

	// 新規契約を追加する
	public Contract(int roomId, String owner, String tenant, LocalDate startDate, LocalDate endDate, //
			LocalDate deliverDate, int rent, String rentPaymentTerm, int rentDeadline, //
			int managementFee, String managementFeePaymentTerm, int managementFeeDeadline, //
			int deposit, int parkingFee, int facilitiesFee, int giftMoney, String paymentMethod, //
			String handingFee, String accountName, String bankName, String accountType, //
			String account, String documentAddress, String remarks) {
		super();
		this.roomId = roomId;
		this.owner = owner;
		this.tenant = tenant;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deliverDate = deliverDate;
		this.rent = rent;
		this.rentPaymentTerm = rentPaymentTerm;
		this.rentDeadline = rentDeadline;
		this.managementFee = managementFee;
		this.managementFeePaymentTerm = managementFeePaymentTerm;
		this.managementFeeDeadline = managementFeeDeadline;
		this.deposit = deposit;
		this.parkingFee = parkingFee;
		this.facilitiesFee = facilitiesFee;
		this.giftMoney = giftMoney;
		this.paymentMethod = paymentMethod;
		this.handingFee = handingFee;
		this.accountName = accountName;
		this.bankName = bankName;
		this.accountType = accountType;
		this.account = account;
		this.documentAddress = documentAddress;
		this.remarks = remarks;
	}
	// 契約内容を編集する
	public Contract(String owner, LocalDate startDate, LocalDate endDate, LocalDate deliverDate, //
			int rent, String rentPaymentTerm, int rentDeadline, int managementFee, //
			String managementFeePaymentTerm, int managementFeeDeadline, int deposit, //
			int parkingFee, int facilitiesFee, int giftMoney, String paymentMethod, //
			String handingFee, String accountName, String bankName, String accountType, //
			String account, String documentAddress, String remarks) {
		super();
		this.owner = owner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deliverDate = deliverDate;
		this.rent = rent;
		this.rentPaymentTerm = rentPaymentTerm;
		this.rentDeadline = rentDeadline;
		this.managementFee = managementFee;
		this.managementFeePaymentTerm = managementFeePaymentTerm;
		this.managementFeeDeadline = managementFeeDeadline;
		this.deposit = deposit;
		this.parkingFee = parkingFee;
		this.facilitiesFee = facilitiesFee;
		this.giftMoney = giftMoney;
		this.paymentMethod = paymentMethod;
		this.handingFee = handingFee;
		this.accountName = accountName;
		this.bankName = bankName;
		this.accountType = accountType;
		this.account = account;
		this.documentAddress = documentAddress;
		this.remarks = remarks;
	}

	// getterとsetter
	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
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

	public LocalDate getDeliverDate() {
		return deliverDate;
	}

	public int getRent() {
		return rent;
	}

	public String getRentPaymentTerm() {
		return rentPaymentTerm;
	}

	public int getRentDeadline() {
		return rentDeadline;
	}

	public int getManagementFee() {
		return managementFee;
	}

	public String getManagementFeePaymentTerm() {
		return managementFeePaymentTerm;
	}

	public int getManagementFeeDeadline() {
		return managementFeeDeadline;
	}

	public int getDeposit() {
		return deposit;
	}

	public int getParkingFee() {
		return parkingFee;
	}

	public int getFacilitiesFee() {
		return facilitiesFee;
	}

	public int getGiftMoney() {
		return giftMoney;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public String getHandingFee() {
		return handingFee;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getBankName() {
		return bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccount() {
		return account;
	}

	public String getDocumentAddress() {
		return documentAddress;
	}

	public String getRemarks() {
		return remarks;
	}
}
