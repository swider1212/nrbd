package com.pl.nrdb.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Optional<Room> findByRoomNumber(Integer roomNumber);

    boolean existsByRoomNumber(Integer roomNumber);
}
