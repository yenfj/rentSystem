package com.example.rentSystem.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.rentSystem.entity.Room;

@Mapper
public interface RoomDAO {

	// 新規部屋を追加する
	public Room insertRoom(Room room);
	
	// 部屋状態を更新する
	public void updateRoomState(int roomId, String state);
}
