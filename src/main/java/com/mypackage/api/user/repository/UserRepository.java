package com.mypackage.api.user.repository;


import com.mypackage.api.user.domain.User;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends Neo4jRepository<User> {

    @Query("MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r")
    void emptyData();
}
