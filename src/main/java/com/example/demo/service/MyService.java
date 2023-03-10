package com.example.demo.service;

import com.example.demo.repo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(){

        User user = new User();

        user.setName("omar");

        userRepository.save(user);

        return user;
    }

    public List<UserDTO> getAllUser(){

        Iterable<User> users= userRepository.findAll();


        return mapUserTOUserDTO((List<User>) users);

    }

    public List<UserDTO> getByName(String name){


        List<User> users = userRepository.findAllByName(name);

        return mapUserTOUserDTO(users);

    }


    public List<UserDTO> mapUserTOUserDTO(List<User> users){

        List<UserDTO> userDTOS = new ArrayList<>();

        for(User user: users){

            UserDTO userDTO = new UserDTO();

            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());

            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

}
