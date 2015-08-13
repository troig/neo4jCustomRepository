package com.mypackage.api.user.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Set;

/**
 * Intern user information
 *
 * @author Tomeu Roig
 */
public class User extends IdentifiableEntity {

   @Indexed
   private String mail;

   /** User stays */
   @RelatedTo(type = "HAS_STAY",  direction = Direction.OUTGOING)
   Set<Stay> stays;

   public String getMail() {
      return mail;
   }

   public void setMail(String mail) {
      this.mail = mail;
   }

   public Set<Stay> getStays() {
      return stays;
   }

   public void addStay(Stay stay) {
      stays.add(stay);
   }
}
