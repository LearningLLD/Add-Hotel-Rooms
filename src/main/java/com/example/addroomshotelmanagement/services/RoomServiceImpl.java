package com.example.addroomshotelmanagement.services;

import java.util.Optional;

import com.example.addroomshotelmanagement.exceptions.UnAuthorizedAccess;
import com.example.addroomshotelmanagement.exceptions.UserNotFoundException;
import com.example.addroomshotelmanagement.models.Room;
import com.example.addroomshotelmanagement.models.RoomType;
import com.example.addroomshotelmanagement.models.User;
import com.example.addroomshotelmanagement.models.UserType;
import com.example.addroomshotelmanagement.repositories.RoomRepository;
import com.example.addroomshotelmanagement.repositories.UserRepository;

public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;
    private UserRepository userRepository;

    public RoomServiceImpl(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Room addRoom(long userId, String roomName, double price, String roomType, String description)
            throws UserNotFoundException, UnAuthorizedAccess {
                Optional<User> optionalUser = userRepository.findById(userId);
                if(optionalUser.isEmpty()) {
                    throw new UserNotFoundException("User not found in database");
                }
                User user = optionalUser.get();
                if(user.getUserType() == UserType.CUSTOMER) {
                    throw new UnAuthorizedAccess("User not allowed to add room");
                }

                Room room = new Room();
                room.setId(userId);
                room.setName(roomName);
                room.setPrice(price);
                room.setRoomType(RoomType.valueOf(roomType));
                room.setDescription(description);
                
                return roomRepository.add(room);
    }
    
}
