package com.mypackage.api.user.domain;

import org.springframework.data.neo4j.annotation.Indexed;

/**
 * Definition of an identifiable graph entity (node has property <tt>id</tt>)
 *
 * @author Tomeu Roig
 */
public abstract class IdentifiableEntity extends BasicNodeEntity {

   /** Enity identifier */
   @Indexed(unique = true)
   private String id;

   /**
    * Returns the entity identifier
    *
    * @return Entity identifier
    */
   public String getId() {
      return id;
   }

   /**
    * Set the entity identifier
    *
    * @param id Entity identifier
    */
   public void setId(String id) {
      this.id = id;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof IdentifiableEntity)) return false;

      IdentifiableEntity entity = (IdentifiableEntity) o;

      if (id != null ? !id.equals(entity.id) : entity.id != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      return id != null ? id.hashCode() : 0;
   }
}
