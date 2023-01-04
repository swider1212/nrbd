package com.pl.nrdb.keyspace_1.rent;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends CassandraRepository<Rent, String> {

    Optional<Rent> findById(String id);

    Optional<Rent> findByRoomRoomNumberAndClientId(Integer roomNumber, String clientId);

    boolean existsByRoomRoomNumberAndClientId(Integer roomNumber, String clientId);
}
