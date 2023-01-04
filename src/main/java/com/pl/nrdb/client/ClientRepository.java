package com.pl.nrdb.client;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CassandraRepository<Client, String> {
    Optional<Client> findById(String id);

    boolean existsByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    Optional<Client> findByFirstNameAndAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);
}
