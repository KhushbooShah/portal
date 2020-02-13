package com.application.portal.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public String userType;

}
