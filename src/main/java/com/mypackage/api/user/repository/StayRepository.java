package com.mypackage.api.user.repository;


import com.mypackage.api.user.domain.Stay;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * <tt>Repository</tt> for <tt>Stay</tt> entities
 *
 * @author Tomeu Roig
 */
public interface StayRepository extends GraphRepository<Stay>, StayRepositoryCustom {

   /**
    * Find <tt>Stay</tt> by <tt>Id</tt>
    *
    * @param id Reference identifier
    * @return Reference information
    */
   Stay findById(String id);
}
