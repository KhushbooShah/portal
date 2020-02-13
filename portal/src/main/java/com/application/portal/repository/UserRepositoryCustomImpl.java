package com.application.portal.repository;

import com.application.portal.model.User;
import com.mongodb.client.model.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<User> findAllByUserType(String userType) {

        Query query = new Query();
        query.addCriteria(Criteria.where("userType").is(userType));
        query.fields().exclude("id").exclude("password")
                .exclude("userType").exclude("userName");
        return mongoTemplate.find(query,User.class);
    }
}
