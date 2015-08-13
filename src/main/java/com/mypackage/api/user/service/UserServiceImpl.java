package com.mypackage.api.user.service;

import com.mypackage.api.user.domain.User;
import com.mypackage.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   UserRepository userRepository;

   @Override
   public User create(User user) {
      return userRepository.save(user);
   }

   @Override
   public User update(User user) {
      return userRepository.save(user);
   }

   @Override
   public void delete(User user) {
      userRepository.delete(user);
   }

   @Override
   public User findUserById(String mail) {
      return userRepository.findBySchemaPropertyValue("id", mail);
   }
}
