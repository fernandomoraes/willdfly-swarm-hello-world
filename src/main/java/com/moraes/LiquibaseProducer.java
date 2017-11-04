package com.moraes;


import liquibase.integration.cdi.CDILiquibaseConfig;
import liquibase.integration.cdi.annotations.LiquibaseType;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@Dependent
public class LiquibaseProducer {

    @Resource(lookup = "java:jboss/datasources/MigrationsDS")
    private DataSource dataSource;

    @Produces
    @LiquibaseType
    public CDILiquibaseConfig createConfig() {
        final CDILiquibaseConfig config = new CDILiquibaseConfig();
        config.setChangeLog("liquibase/db.changelog.xml");
        return config;
    }

    @Produces
    @LiquibaseType
    private DataSource createDS() {
        return dataSource;
    }

    @Produces
    @LiquibaseType
    private ResourceAccessor createResourceAccessor() {
        return new ClassLoaderResourceAccessor(getClass().getClassLoader());
    }

}
