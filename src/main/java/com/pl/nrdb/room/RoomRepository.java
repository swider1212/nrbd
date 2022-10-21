package com.pl.nrdb.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Room> findByRoomNumber(Integer roomNumber);

    boolean existsByRoomNumber(Integer roomNumber);
}
