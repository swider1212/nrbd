package com.pl.nrdb.rent;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RentRepository extends MongoRepository<Rent, String> {

    Optional<Rent> findById(String id);

    Optional<Rent> findByRoomRoomNumberAndClientId(Integer roomNumber, String clientId);

    boolean existsByRoomRoomNumberAndClientId(Integer roomNumber, String clientId);
}
