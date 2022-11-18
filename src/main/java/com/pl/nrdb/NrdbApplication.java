package com.pl.nrdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories()
public class NrdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(NrdbApplication.class, args);
    }

}
