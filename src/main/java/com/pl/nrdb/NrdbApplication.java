package com.pl.nrdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
public class NrdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(NrdbApplication.class, args);
    }
}

