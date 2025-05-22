package com.example.addroomshotelmanagement.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.addroomshotelmanagement.models.Room;
import com.example.addroomshotelmanagement.models.RoomType;

public class RoomRepositoryImpl implements RoomRepository{

    Map<RoomType, List<Room>> roomDb = new HashMap<>();

    @Override
    public Room add(Room room) {
        if(roomDb.containsKey(room.getRoomType())) {
            roomDb.get(room.getRoomType()).add(room);
        } else {
            List<Room> roomList = new ArrayList<>();
            roomList.add(room);
            roomDb.put(room.getRoomType(), roomList);
        }

        return room;
    }

    @Override
    public List<Room> getRooms() {
        List<Room> roomList = new ArrayList<>();
        for(List<Room> room : roomDb.values()) {
            roomList.addAll(room);
        }

        return roomList;
    }

    @Override
    public List<Room> getRoomsByRoomType(RoomType roomType) {
        return roomDb.get(roomType);
    }

    @Override
    public Room save(Room room) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    
}
