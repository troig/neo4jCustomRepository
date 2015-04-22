package com.mypackage.api.user.repository;

import com.mypackage.api.user.domain.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

   @Override
   public User findBySomeCriteria(String criteria) {
      User user = new User();
      user.setMail("dumy@dumy.com");
      return user;
   }
}
