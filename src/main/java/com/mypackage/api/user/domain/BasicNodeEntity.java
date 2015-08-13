package com.mypackage.api.user.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.io.Serializable;

/**
 * Basic graph entity
 *
 * @author Tomeu Roig
 */
@NodeEntity
public abstract class BasicNodeEntity implements Serializable {

   /** Graph node identifier */
   @GraphId
   private Long nodeId;

   /**
    * Return node graph identifier.
    *
    * @return Node graph identifier
    */
   public Long getNodeId() {
      return nodeId;
   }

   @Override
   public abstract boolean equals(Object o);

   @Override
   public abstract int hashCode();
}
