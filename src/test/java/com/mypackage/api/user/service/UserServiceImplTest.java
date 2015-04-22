package com.mypackage.api.user.service;

import com.mypackage.api.user.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/services-test-context.xml"})
public class UserServiceImplTest {

   @Autowired
   UserService userService;

   @Test
   public void testCreate() {
      User user = new User();
      user.setMail("a@b.com");
      userService.create(user);
   }

   @Test
   public void testFindByMail() throws Exception {
      User user = userService.findUserByMail("a@b.com");
      Assert.assertNotNull(user);
      Assert.assertEquals("a@b.com", user.getMail());
   }

   @Test
   public void testFindBySomeCriteria() throws Exception {
      User user = userService.findBySomeCriteria("someCriteria");
      Assert.assertNotNull(user);
      Assert.assertEquals("dumy@dumy.com", user.getMail());
   }
}