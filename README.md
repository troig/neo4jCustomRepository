# neo4jCustomRepository
Spring-data-neo4j custom repository example


This is only a basic example of how we can create and combine custom repositories in spring-data-neo4j

The purpose of this project is supporting the StackOverflow question:
http://stackoverflow.com/questions/29724312/no-property-found-for-type-combining-repositories-spring-data-neo4j

How to run:

Edit src\test\resources\services-test-context.xml and set the database url and credentials:

```
<!-- TODO Change database url and credentials -->
<bean id="graphDatabaseService" class="org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase">
   <constructor-arg value="http://xxx.sb04.stations.graphenedb.com:24789/db/data/" index="0"/>
   <constructor-arg value="yyy" index="1"/>
   <constructor-arg value="zzz" index="2"/>
</bean>
```

Run test com.mypackage.api.user.service.UserServiceImplTest