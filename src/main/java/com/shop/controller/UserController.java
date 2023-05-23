package com.shop.controller;

import com.shop.dto.User;
import com.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    @GetMapping("/user-create")
    public String createUserForm()
    {
        return "user-create";
    }

    @PostMapping("/user/create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String userInfo(@PathVariable UUID id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-info";
    }
    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
