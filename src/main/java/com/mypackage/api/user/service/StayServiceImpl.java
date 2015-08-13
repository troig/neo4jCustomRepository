package com.mypackage.api.user.service;

import com.mypackage.api.user.domain.Stay;
import com.mypackage.api.user.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;


/**
 * Basic <tt>Stay</tt> service management implementation
 *
 * @author Tomeu Roig
 */
@Service
public class StayServiceImpl implements StayService {

   /** Stay repository */
   @Autowired
   StayRepository stayRepository;

   @Autowired
   Neo4jOperations template;

   @Override
   public Stay create(Stay stay) {
      return stayRepository.save(stay);
   }

   @Override
   public void delete(Stay stay) {
      stayRepository.delete(stay);
   }

   @Override
   public Stay findStayById(String mail) {
      return null;
   }
}
