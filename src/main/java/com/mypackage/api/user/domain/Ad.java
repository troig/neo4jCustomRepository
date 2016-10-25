package com.mypackage.api.user.domain;


import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

public class Ad extends BasicNodeEntity {

    private String id;

    private String title;

    @Relationship(type = "HAS_ADVERTISER", direction = Relationship.OUTGOING)
    private User advertiser;

    @Relationship(type = "IS_FAVOURITE_TO", direction = Relationship.OUTGOING)
    private Set<User> favourites = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(User advertiser) {
        this.advertiser = advertiser;
    }

    public Set<User> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<User> favourites) {
        this.favourites = favourites;
    }
}
