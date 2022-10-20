package com.pl.nrdb.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findById(Integer id);

    boolean existsByFirstNameAndAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    Optional<Client> findByFirstNameAndAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);
}
