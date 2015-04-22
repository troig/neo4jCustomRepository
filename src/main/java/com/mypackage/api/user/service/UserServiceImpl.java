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
   public void create(User user) {
      userRepository.save(user);
   }

   @Override
   public User findUserByMail(String mail) {
      return userRepository.findBySchemaPropertyValue("mail", mail);
   }

   @Override
   public User findBySomeCriteria(String criteria) {
      return userRepository.findBySomeCriteria(criteria);
   }
}
