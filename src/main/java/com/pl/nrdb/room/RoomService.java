package com.pl.nrdb.room;

import com.pl.nrdb.room.exceptions.RoomAlreadyExistException;
import com.pl.nrdb.room.exceptions.RoomNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room fetchRoom(Integer roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).orElseThrow(() -> new RoomNotFoundException(roomNumber));
    }

    private void checkDuplicateRoom(Integer roomNumber) {
        if (roomRepository.existsByRoomNumber(roomNumber)) {
            throw new RoomAlreadyExistException(roomNumber);
        }
    }

    private Room addSingleRoom(Integer roomNumber, Boolean isAvailable) {
        checkDuplicateRoom(roomNumber);
        SingleRoom singleRoom = SingleRoom.builder()
                .roomNumber(roomNumber)
                .isAvailable(isAvailable)
                .build();
        return roomRepository.save(singleRoom);
    }

    private Room addDoubleRoom(Integer roomNumber, Boolean isAvailable) {
        checkDuplicateRoom(roomNumber);
        DoubleRoom doubleRoom = DoubleRoom.builder()
                .roomNumber(roomNumber)
                .isAvailable(isAvailable)
                .build();
        return roomRepository.save(doubleRoom);
    }

    private Room addTripleRoom(Integer roomNumber, Boolean isAvailable) {
        checkDuplicateRoom(roomNumber);
        TripleRoom tripleRoom = TripleRoom.builder()
                .roomNumber(roomNumber)
                .isAvailable(isAvailable)
                .build();
        return roomRepository.save(tripleRoom);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    private void deleteRoom(Integer roomNumber) {
        roomRepository.delete(fetchRoom(roomNumber));
    }
}
