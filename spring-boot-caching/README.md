# spring-jpa-relationships

There are 3 levels of caching:
- Level 1 - enabled by default
- Level 2 - needs to be enabled
- Memory - default database fetch

In spring boot the caching is done in the following method:
- Level 1 - at the transaction level. eg: If data is retreived in a transaction and then refetched later, a database fetch won't be performed for the second request,
instead the data will be returned from the persistance context
- Level 2 - on data that we set to be stored in the L2 data cache. When storing in l2 we need to choose data that does not change on a regular basis

# How to set up L2 caching:

Add dependency in pom.xml to enable the EhCache framework
```java
		<!--Dependency for second level cache-->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-ehcache</artifactId>
		</dependency>
```
We need to add the following attributes to application.properties:

**1. enable second level cache**
- spring.jpa.properties.hibernate.cache.use_second_level_cache = true

**2. specify the caching framework**
- spring.jpa.properties.hibernate.cache.region.factory_class = org.hibernate.cache.ehcache.EhCacheRegionFactory

**3. only cache what I tell to cache**
- spring.jpa.properties.javax.persistence.sharedCache.mode = ENABLE_SELECTIVE

In order to store data in the l2 cache we must set the @Cacheable on the entity that we want to store data about
