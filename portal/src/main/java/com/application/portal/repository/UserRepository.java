package com.application.portal.repository;

import com.application.portal.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>,UserRepositoryCustom {

     User findByFirstName(String firstName);
     //List<User> findAllByUserType(String userType);


}
