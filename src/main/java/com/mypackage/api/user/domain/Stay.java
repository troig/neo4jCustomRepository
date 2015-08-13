package com.mypackage.api.user.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Definition of a stay
 *
 * @author Tomeu Roig
 */
public class Stay extends IdentifiableEntity {
   @RelatedTo(type = "HAS_STAY", direction = Direction.INCOMING)
   User user;

   String name;

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
