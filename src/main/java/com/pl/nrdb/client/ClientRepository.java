package com.pl.nrdb.client;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findById(String id);

    boolean existsByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    Optional<Client> findByFirstNameAndAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);
}
