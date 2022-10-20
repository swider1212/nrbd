package com.pl.nrdb.room;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room fetchRoom(Integer roomNumber){
        return roomRepository.findByRoomNumber(roomNumber).orElseThrow(() -> new RoomNotFoundException(roomNumber));
    }

    private void checkDuplicateRoom(Integer roomNumber){
        if (roomRepository.existsByRoomNumber(roomNumber)) {
            throw new RoomAlreadyExistException(roomNumber);
        }
    }

    private Room addRoom(Integer roomNumber, Boolean isAvailable){
        checkDuplicateRoom(roomNumber);
        Room room = Room.builder()
                .roomNumber(roomNumber)
                .isAvailable(isAvailable)
                .build();
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    private void deleteRoom(Integer roomNumber) {
        roomRepository.delete(fetchRoom(roomNumber));
    }
}
