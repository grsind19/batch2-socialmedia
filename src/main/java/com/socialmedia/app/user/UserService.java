package com.socialmedia.app.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public UserDAO convertUserDTOtoDAO(UserDTO userDTO){
        return modelMapper.map(userDTO, UserDAO.class);
    }

    //get all users
    //arguement - nil
    //return- list of users object
    public ArrayList<UserDTO>  getAllUsers(){
        List<UserDAO> userdoas = userRepository.findAll();
        ArrayList<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (UserDAO userDAo: userdoas) {
            userDTOS.add(modelMapper.map(userDAo, UserDTO.class));
        }
        return userDTOS;
    }

    //get user by Id
    //arguement - user_id
    //return - user object
    public UserDTO getUserById(Integer user_id){
        Optional<UserDAO> userDAO = userRepository.findById(user_id);
        return modelMapper.map(userDAO.get(), UserDTO.class);
    }

    //create user
    //arguement - user object without id
    //return - user object with id
    public UserDTO createUser(UserDTO userDTO){
        UserDAO userDAO = this.convertUserDTOtoDAO(userDTO);
        userDAO = userRepository.save(userDAO);
        return modelMapper.map(userDAO, UserDTO.class);
    }

    //update user
    //argument - user_id, user_object
    //return - updated user object
    public UserDTO updateUser(Integer user_id, UserDTO userDTO){
        UserDAO userDAO = this.convertUserDTOtoDAO(userDTO);
        userDAO.setId(user_id);
        userDAO = userRepository.save(userDAO);
        return modelMapper.map(userDAO, UserDTO.class);
    }

    //delete user
    //arguement - user_id
    //return - nil
    public void deleteUser(Integer user_id){
        userRepository.deleteById(user_id);
    }
}
