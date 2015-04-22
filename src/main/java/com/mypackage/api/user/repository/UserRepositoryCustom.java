package com.mypackage.api.user.repository;

import com.mypackage.api.user.domain.User;

public interface UserRepositoryCustom {
  User findBySomeCriteria(String criteria);
}
