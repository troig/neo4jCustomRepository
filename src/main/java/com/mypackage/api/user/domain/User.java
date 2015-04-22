package com.mypackage.api.user.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity()
public class User  {

   @SuppressWarnings("UnusedDeclaration")
   @GraphId
   private Long nodeId;

   @Indexed
   String mail;

   public String getMail() {
      return mail;
   }

   public void setMail(String mail) {
      this.mail = mail;
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User)) return false;

      User user = (User) o;

      if (!mail.equals(user.mail)) return false;

      return true;
   }

   @Override
   public int hashCode() {
      return mail.hashCode();
   }
}
