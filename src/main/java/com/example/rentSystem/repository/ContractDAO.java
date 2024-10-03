package com.example.rentSystem.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.example.rentSystem.entity.Contract;
import com.example.rentSystem.vo.SearchContractReq;
import com.example.rentSystem.vo.SearchContractRes;

@Mapper
public interface ContractDAO {
	
	// 新規契約を追加する
	public void insertContract(Contract contract);
	
	// 契約内容を編集する
	public void updateContract(Contract contract);
	
	// 契約Idによって契約を削除する
	public void deleteContract(int contractId);
	
	// 検索条件によって契約を検索する
	public List<SearchContractRes> selectContract(
			@Param("searchContarctReq") SearchContractReq searchContarctReq);
	
	// 契約Idによって契約を検索する
	public Contract selectContractById(int contractId);
}
