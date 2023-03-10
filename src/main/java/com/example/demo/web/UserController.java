package com.example.demo.web;


import com.example.demo.service.MyService;
import com.example.demo.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    MyService myService;

    @GetMapping("/users")
    List<UserDTO> getAllusers(){


        return myService.getAllUser();

    }


    @GetMapping("/user")

    List<UserDTO> getAllByusers(@RequestParam String name){


        return myService.getByName(name);

    }


}
