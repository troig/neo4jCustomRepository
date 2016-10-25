package com.mypackage.api.user.repository;


import com.mypackage.api.user.domain.Ad;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdRepository extends Neo4jRepository<Ad> {

    @Query("MATCH (ad:Ad),(user:User) " +
            "WHERE ad.id = {0} AND user.id = {1} " +
            "AND NOT (ad)-[:IS_FAVOURITE_TO]->(user)" +
            "CREATE (ad)-[r:IS_FAVOURITE_TO]->(user) " +
            "RETURN ad")
    Ad addFavourite(String adId, String userId);


    @Query("MATCH (ad:Ad)," +
            "(ad)-[has_advertiser:HAS_ADVERTISER]->(advertiser:User)," +
            "(ad)-[is_favourite_to: IS_FAVOURITE_TO] -> (favouriteUser:User)" +
            "return ad, has_advertiser, advertiser, " +
            "is_favourite_to, favouriteUser ")
    List<Ad> findAds();
}
