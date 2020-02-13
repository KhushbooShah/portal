package com.application.portal.controller;

import com.application.portal.constants.UserType;
import com.application.portal.model.User;
import com.application.portal.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserInfoController {

    public static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeUser(){
        logger.info("Inside Welcome User method ****");
        return new ResponseEntity<>("Welcome user", HttpStatus.OK);
    }

    /**
     * Method register any new user
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param userType can be student or professor
     * @return
     */
    @PostMapping("/registerUser/{firstName}/{lastName}/{userName}/{password}/{userType}")
    public ResponseEntity<String> registerUser(@PathVariable String firstName,
                                               @PathVariable String lastName,
                                               @PathVariable String userName,
                                               @PathVariable String password,
                                               @PathVariable String userType){
        logger.info("**** Inside registerUser() method ****");
        User newUser = new User();
        newUser.firstName = firstName;
        newUser.lastName = lastName;
        newUser.userName = userName;
        newUser.password = password;
        newUser.userType = userType.equalsIgnoreCase("student")? UserType.STUDENT.toString() : UserType.PROFESSOR.toString();
        userRepository.save(newUser);
        return new ResponseEntity<>("User with username "+userName+" created successfully!"
                ,HttpStatus.OK);
    }

    @GetMapping("/listStudents")
    public List<User> getStudents(){
        logger.info("**** Inside getStudents() method ****");
        return userRepository.findAllByUserType(UserType.STUDENT.toString());
    }

    @GetMapping("/listProfessors")
    public List<User> getProfessors(){
        logger.info("**** Inside getProfessors() method ****");
        return userRepository.findAllByUserType(UserType.PROFESSOR.toString());
    }
}
