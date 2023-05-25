package com.shop.service;

import com.shop.entity.User;
import com.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    //чтобы могли изменить данные в базе данных создаем:
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(UUID id)
    {
        return userRepository.getById(id);
    }
    public List<User> findAll() { return userRepository.findAll(); }
    public void saveUser(User user) { userRepository.save(user); }
    public void deleteUserById(UUID id)
    {
        userRepository.deleteById(id);
    }
}

