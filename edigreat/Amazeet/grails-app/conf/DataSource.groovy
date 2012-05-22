dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
   // driverClassName = "org.hsqldb.jdbcDriver"    
    username = "sa"
    password = ""
}

//hibernate.properties
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate (checa el esquema que corresponda)', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE"
            logSql = true //Habilita log para hibernate
			formatSql = true  
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            //url = "jdbc:h2:prodDb;MVCC=TRUE"
            url =  "jdbc:hsqldb:hsql://localhost/dbasembly"
            
            dialect = "org.hibernate.dialect.HSQLDialect"               
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS"
            }
        }
    }
}
