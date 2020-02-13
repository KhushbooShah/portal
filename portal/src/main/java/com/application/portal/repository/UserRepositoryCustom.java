package com.application.portal.repository;

import com.application.portal.model.User;
import java.util.List;

public interface UserRepositoryCustom {
    List<User> findAllByUserType(String userType);
}
