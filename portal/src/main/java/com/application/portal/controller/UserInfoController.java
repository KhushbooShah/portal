package com.application.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserInfoController {

    public static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);


    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeUser(){
        logger.info("Inside Welcome User method ****");
        return new ResponseEntity<>("Welcome user", HttpStatus.OK);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param userType
     * @return
     */
    @GetMapping("/registerUser/{firstName}/{lastName}/{userName}/{password}/{userType}")
    public ResponseEntity<String> registerUser(@PathVariable String firstName,
                                               @PathVariable String lastName,
                                               @PathVariable String userName,
                                               @PathVariable String password,
                                               @PathVariable String userType){
        logger.info("**** Inside registerUser method ****");

        return new ResponseEntity<>("User with username "+userName+" created successfully!"
                ,HttpStatus.OK);
    }

}
