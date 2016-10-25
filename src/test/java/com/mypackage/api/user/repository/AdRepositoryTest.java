package com.mypackage.api.user.repository;

import com.mypackage.api.user.domain.Ad;
import com.mypackage.api.user.domain.User;
import com.mypackage.api.user.domain.config.Neo4jConfig;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Neo4jConfig.class)
public class AdRepositoryTest {

    @Autowired
    Session session;

    @Autowired
    AdRepository adRepository;

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        // 1. Create users
        User advertiser = new User();
        advertiser.setId("1");
        advertiser.setName("advertiser");
        session.save(advertiser);

        User userFavourite = new User();
        userFavourite.setId("2");
        userFavourite.setName("favourite");
        session.save(userFavourite);

        // 2. Create ad
        Ad ad = new Ad();
        ad.setId("3");
        ad.setTitle("Ad");
        ad.setAdvertiser(advertiser);
        session.save(ad);

        // 3. Ad favourite relationship through AdRepository
        adRepository.addFavourite("3", "2");
    }

    @After
    public void tearDown() throws Exception {
        // Empty bbdd
        userRepository.emptyData();
    }

    @Test
    public void testErrorQueryResultManyReferencesSameNode() {
        // 4. Find ads
        List<Ad> ads = adRepository.findAds();
        Assert.assertEquals(1, ads.size());
        Ad ad = ads.get(0);

        // This assert fails the test. Should return just 1 favourite, but there 2 are retrieved
        Assert.assertEquals(1, ad.getFavourites().size());
    }
}