package com.example.rentSystem.service.ifs;

import java.util.List;

import com.example.rentSystem.entity.Contract;
import com.example.rentSystem.vo.SearchContractReq;
import com.example.rentSystem.vo.SearchContractRes;

public interface ContractService {
	
	// 新規契約を追加する
	public void createContract(Contract contract);
	
	// 契約内容を編集する
	public void updateContract(Contract contract);
	
	// 契約Idによって契約を削除する
	public void deleteContarct(List<Integer> contractIdList);
	
	// 検索条件によって契約を検索する
	public List<SearchContractRes> searchContract(SearchContractReq searchContarctReq);
}
