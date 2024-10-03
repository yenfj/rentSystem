package com.example.rentSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.rentSystem.vo.SearchContractReq;

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * .htmlを表示するためのcontroller
 */
@Controller
public class ContractHtmlController {
	
	// 契約一覧ページへの GET リクエストを処理
	@GetMapping(value = "/contract")
	public String contract(Model model) {
		SearchContractReq searchRequest = new SearchContractReq();
		model.addAttribute("searchRequest", searchRequest);
		return "Contract";
	}
	
	// 新規契約を追加するページへの GET リクエストを処理
	@GetMapping(value = "/contract/add_contract")
	public String addContract() {
		return "AddAndUpdateContract"; // AddAndUpdateContractテンプレートを返す
	}
	
//	// 新規契約を追加するページへのGETリクエストを処理
//	@GetMapping(value = "/contract/update_contract")
//	public String updateContract() {
//		return "AddAndUpdateContract"; // AddAndUpdateContractテンプレートを返す
//	}
//	
//	// 新規契約を追加するページへのGETリクエストを処理
//	@GetMapping(value = "/contract/show_contract")
//	public String showContract() {
//		return "AddAndUpdateContract"; // AddAndUpdateContractテンプレートを返す
//	}
}
