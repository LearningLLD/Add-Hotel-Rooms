package com.example.addroomshotelmanagement.controllers;

import com.example.addroomshotelmanagement.dtos.AddRoomRequestDto;
import com.example.addroomshotelmanagement.dtos.AddRoomResponseDto;
import com.example.addroomshotelmanagement.dtos.ResponseStatus;
import com.example.addroomshotelmanagement.models.Room;
import com.example.addroomshotelmanagement.services.RoomService;

public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public AddRoomResponseDto addRoom(AddRoomRequestDto requestDto) {
        Room room;
        AddRoomResponseDto response = new AddRoomResponseDto();
        try {
            room = roomService.addRoom(requestDto.getUserId(), requestDto.getName(), requestDto.getPrice(), requestDto.getRoomType(), requestDto.getDescription());
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
        response.setRoom(room);
        response.setResponseStatus(ResponseStatus.SUCCESS);
        return response;
    }
}