package com.mypackage.api.user.repository;


import com.mypackage.api.user.domain.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GraphRepository<User>, UserRepositoryCustom {
}
