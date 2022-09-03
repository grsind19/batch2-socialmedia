package com.socialmedia.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ArrayList<UserDTO> getAlluser(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{user_id}")
    public UserDTO getUserById(@PathVariable("user_id") Integer user_id){
        return userService.getUserById(user_id);
    }


    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PutMapping("/user/{user_id}")
    public UserDTO updateUser(@PathVariable("user_id") Integer user_id, @RequestBody UserDTO userDTO){
        return userService.updateUser(user_id, userDTO);
    }

    @DeleteMapping("/user/{user_id}")
    public void deleteUser(@PathVariable("user_id") Integer user_id){
        userService.deleteUser(user_id);
    }
}
