package com.pl.nrdb.rent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    Optional<Rent> findById(Integer id);

    Optional<Rent> findByRoomRoomNumberAndClientId(Integer roomNumber, Integer clientId);

    boolean existsByRoomRoomNumberAndClientId(Integer roomNumber, Integer clientId);
}
