package com.example.rentSystem.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.rentSystem.entity.Building;

@Mapper
public interface BuildingDAO {

	// 新規建物を追加する
	public void insertBuilding(Building building);
}
