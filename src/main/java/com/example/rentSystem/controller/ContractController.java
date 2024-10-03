package com.example.rentSystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rentSystem.repository.ContractDAO;
import com.example.rentSystem.vo.SearchContractReq;
import com.example.rentSystem.vo.SearchContractRes;

@Controller
public class ContractController {

    @Autowired
    private ContractDAO contractDAO;

    // 検索条件によって契約情報を探す、 GET リクエストに対するメソッド
    @GetMapping(value = "/search")
    public String searchContracts(
    		@RequestParam(required = false) int contractId,
            @RequestParam(required = false) String buildingName,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) String owner,
            @RequestParam(required = false) String tenant,
            @RequestParam(required = false, defaultValue = "0") int state,
            Model model) {

        // 検索リクエストを作成
    	SearchContractReq searchRequest = new SearchContractReq();
        searchRequest.setContractId(contractId);
        searchRequest.setBuildingName(buildingName);
        searchRequest.setStartDate(startDate);
        searchRequest.setEndDate(endDate);
        searchRequest.setOwner(owner);
        searchRequest.setTenant(tenant);
        
        // すべてのパラメータが無効な場合、到期日が三か月以内のデータを検索
        if (!hasValidParams(searchRequest)) {
            searchRequest.setEndDate(LocalDate.now().plusMonths(3));
        }

        // DAO メソッドを呼び出して契約リストを取得
        List<SearchContractRes> contracts = contractDAO.selectContract(searchRequest);
        
        // contractStateによるフィルタリング
        if (state > 0) { // 確保狀態在有效範圍內
            contracts = contracts.stream()
                    .filter(contract -> determineContractState(
                            contract.getStartDate(),
                            contract.getEndDate(),
                            contract.getContractId()) == state)
                    .collect(Collectors.toList());
        }
        
        model.addAttribute("contracts", contracts);
        model.addAttribute("contractState", state);
        model.addAttribute("searchRequest", searchRequest);
        return "Contract";
    }

    // 有効なパラメータが存在するかどうかを確認するメソッド
    private boolean hasValidParams(SearchContractReq searchRequest) {
        return !(isEmptyOrZero(searchRequest.getContractId()) &&
                 isEmptyOrNull(searchRequest.getBuildingName()) &&
                 isEmptyOrNull(searchRequest.getStartDate()) &&
                 isEmptyOrNull(searchRequest.getEndDate()) &&
                 isEmptyOrNull(searchRequest.getOwner()) &&
                 isEmptyOrNull(searchRequest.getTenant()));
    }

    // 整数が0かどうかを確認するメソッド
    private boolean isEmptyOrZero(int value) {
        return value == 0;
    }

    // 文字列が空かどうかを確認するメソッド
    private boolean isEmptyOrNull(String value) {
        return value == null || value.trim().isEmpty();
    }

    // LocalDateがnullかどうかを確認するメソッド
    private boolean isEmptyOrNull(LocalDate value) {
        return value == null;
    }

    // 契約状態を決定するメソッド
    private int determineContractState(LocalDate startDate, LocalDate endDate, int contractId) {
        // 現在日付を取得
        LocalDate today = LocalDate.now();

        // todayがstartDateより前かつcontractIdが3で割り切れる場合
        if (today.isBefore(startDate) && contractId % 3 == 0) {
            return 1; // 特定条件を満たす場合は1を返す
        }

        if (today.isAfter(startDate)) {
            return 2; // 契約完了
        }
        if (today.isAfter(endDate.plusMonths(1))) {
            return 4; // 契約終了（endDate 一ヶ月後）
        }
        if (today.isAfter(endDate) && today.isBefore(endDate.plusMonths(1))) {
            return 5; // 解約中（endDate後の一ヶ月内）
        }
        return 3; // 契約進行中
    }
}
