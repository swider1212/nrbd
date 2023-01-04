package com.pl.nrdb.keyspace_1.room;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends CassandraRepository<Room, String> {

    Optional<Room> findByRoomNumber(Integer roomNumber);

    boolean existsByRoomNumber(Integer roomNumber);
}
