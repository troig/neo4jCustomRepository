package com.mypackage.api.user.identifier;

import java.util.UUID;

/**
 * Basic Id generation based on UUID
 *
 * @author Tomeu Roig
 */
public class IdentifierFactoryImpl implements IdentifierFactory<String> {

   @Override
   public String generateId() {
      return UUID.randomUUID().toString();
   }
}
