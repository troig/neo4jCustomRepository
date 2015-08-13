package com.mypackage.api.user.service;


import com.mypackage.api.user.domain.Stay;

/**
 * Stay management service
 *
 * @author Tomeu Roig
 */
public interface StayService {

   Stay create(Stay stay);

   void delete(Stay stay);

   Stay findStayById(String mail);
}

