package com.example.rentSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentSystem.entity.Contract;
import com.example.rentSystem.repository.ContractDAO;
import com.example.rentSystem.service.ifs.ContractService;
import com.example.rentSystem.vo.SearchContractReq;
import com.example.rentSystem.vo.SearchContractRes;

@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	ContractDAO dao;

	@Override
	public void createContract(Contract contract) {
		dao.insertContract(contract);
	}

	@Override
	public void updateContract(Contract contract) {
		dao.updateContract(contract);
	}

	@Override
	public void deleteContarct(List<Integer> contractIdList) {
		for (int id : contractIdList) {
			dao.deleteContract(id);
		}
	}

	@Override
	public List<SearchContractRes> searchContract(SearchContractReq searchContarctReq) {
		return dao.selectContract(searchContarctReq);
	}
}
