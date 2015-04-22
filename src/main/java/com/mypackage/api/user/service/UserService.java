package com.mypackage.api.user.service;

import com.mypackage.api.user.domain.User;

public interface UserService {

   void create(User user);

   User findUserByMail(String mail);

   User findBySomeCriteria(String criteria);
}
