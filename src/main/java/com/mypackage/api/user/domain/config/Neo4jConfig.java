package com.mypackage.api.user.domain.config;

import com.mypackage.api.user.domain.IdentifiableEntity;
import com.mypackage.api.user.identifier.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.lifecycle.BeforeSaveEvent;

/**
 * Neo4j configuration
 *
 * @author Tomeu Roig
 */
@Configuration
public class Neo4jConfig {

   @Autowired
   IdentifierFactory<String> identifierFactory;

   @Bean
   ApplicationListener<BeforeSaveEvent> beforeSaveEventApplicationListener() {
      return new ApplicationListener<BeforeSaveEvent>() {
         @Override
         public void onApplicationEvent(BeforeSaveEvent event) {
            if (event.getEntity() instanceof IdentifiableEntity) {
               IdentifiableEntity entity = (IdentifiableEntity) event.getEntity();
               if (entity.getId() == null) entity.setId(identifierFactory.generateId());
            }
         }
      };
   }
}
