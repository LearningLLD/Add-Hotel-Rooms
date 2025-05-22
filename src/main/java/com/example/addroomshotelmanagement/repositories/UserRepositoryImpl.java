package com.example.addroomshotelmanagement.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.addroomshotelmanagement.models.User;

public class UserRepositoryImpl implements UserRepository{

    List<User> userDb = new ArrayList<>();

    @Override
    public Optional<User> findById(long userId) {
        return userDb.stream().filter(user -> user.getId() == userId).findFirst();
    }

    @Override
    public User save(User user) {
        userDb.add(user);
        return user;
    }
    
}
