package com.mypackage.api.user.identifier;

import org.springframework.stereotype.Component;

/**
 * Unique identifier factory
 *
 * @author Tomeu Roig
 */
@Component
public interface IdentifierFactory<T> {

   /**
    * Generate a unique identifier.
    *
    * @return Unique identifier
    */
   T generateId();
}
