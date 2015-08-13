package com.mypackage.api.user.service;

import com.mypackage.api.user.domain.User;

public interface UserService {

   User create(User user);

   User update(User user);

   void delete(User user);

   User findUserById(String mail);
}
