package com.example.rentSystem;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rentSystem.entity.Building;
import com.example.rentSystem.entity.Contract;
import com.example.rentSystem.repository.BuildingDAO;
import com.example.rentSystem.repository.ContractDAO;

@SpringBootTest
class RentSystemApplicationTests {
	
	@Autowired
	BuildingDAO bDao;
	
	@Autowired
	ContractDAO cDao;
	
	@Test
	public void test() {
//		Contract res = cDao.insertContract(new Contract(
//				0, 
//				"A", 
//				"B", 
//				LocalDate.of(2015, 4, 1), 
//				LocalDate.of(2015, 4, 5), 
//				LocalDate.of(2020, 3, 31), 
//				10000, 
//				"当月分を", 
//				5, 
//				5000, 
//				"当月分を", 
//				5, 
//				20000, 
//				2500, 
//				2500, 
//				2500, 
//				"持ち参り", 
//				null, 
//				null, 
//				null, 
//				null, 
//				null, 
//				"東京都足立区千住桜木２丁目12-1", 
//				null));
		bDao.insertBuilding(new Building(
				"ARCOBALENO TAKENOTSUKA", 
				"東京都足立区竹の塚２丁目", 
				"マンション", 
				"鉄筋コンクリート", 
				2024, 7, 
				0, 0));
	}
}
