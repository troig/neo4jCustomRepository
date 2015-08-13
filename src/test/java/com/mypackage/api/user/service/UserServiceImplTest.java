package com.mypackage.api.user.service;

import com.mypackage.api.user.domain.Stay;
import com.mypackage.api.user.domain.User;
import junit.framework.Assert;
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

   @Autowired
   StayService stayService;

   @Test
   public void testErrorPersistingOneToManyRelationship() {
      User user = new User();
      user.setMail("test@test.com");

      // 1. Create user
      user = userService.create(user);
      String userId = user.getId();
      Assert.assertNotNull(userId);

      // 2. Create first stay, add stay to user and persist user
      Stay firstStay = new Stay();
      firstStay.setName("Stay1");
      firstStay = stayService.create(firstStay);
      String firstStayId = firstStay.getId();
      Assert.assertNotNull(firstStayId);
      user.addStay(firstStay);
      userService.update(user);

      // Get user from repository: Stay is correctly persisted
      user = userService.findUserById(userId);
      Assert.assertEquals(1, user.getStays().size());

      // 3. Create second stay, add stay to user and persist user
      Stay secondStay = new Stay();
      secondStay.setName("Stay2");
      secondStay = stayService.create(secondStay);
      String secondStayId = secondStay.getId();
      // Check two stays are different
      Assert.assertNotNull(secondStayId);
      Assert.assertNotSame(firstStayId, secondStayId);
      user.addStay(secondStay);
      userService.update(user);

      // At this point, user has both stays
      Assert.assertEquals(2, user.getStays().size());

      // But if we retrieve the user from repository, it just has the first stay, the second one has not persisted
      user = userService.findUserById(userId);
      Assert.assertEquals(2, user.getStays().size()); // This fails
   }
}