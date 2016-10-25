package com.mypackage.api.user.domain;

import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

public class User extends BasicNodeEntity {

    private String id;

    private String name;

    @Relationship(type = "HAS_ADVERTISER", direction = Relationship.INCOMING)
    private Set<Ad> ads = new HashSet<>();

    @Relationship(type = "IS_FAVOURITE_TO", direction = Relationship.INCOMING)
    private Set<Ad> favourites = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Relationship(type = "HAS_ADVERTISER", direction = Relationship.INCOMING)
    public Set<Ad> getAds() {
        return ads;
    }

    @Relationship(type = "HAS_ADVERTISER", direction = Relationship.INCOMING)
    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    @Relationship(type = "IS_FAVOURITE_TO", direction = Relationship.INCOMING)
    public Set<Ad> getFavourites() {
        return favourites;
    }

    @Relationship(type = "IS_FAVOURITE_TO", direction = Relationship.INCOMING)
    public void setFavourites(Set<Ad> favourites) {
        this.favourites = favourites;
    }
}
