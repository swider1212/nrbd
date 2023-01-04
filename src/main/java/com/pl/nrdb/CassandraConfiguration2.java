package com.pl.nrdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = {"com.pl.nrdb.keyspace_2"})
public class CassandraConfiguration2 extends AbstractCassandraConfiguration {



    @Override
    public String getContactPoints() {
        return "127.0.0.1";
    }

    @Override
    protected int getPort() {
        return 9043;
    }

    @Override
    protected String getKeyspaceName() {
        return "cassandra2";
    }
}
