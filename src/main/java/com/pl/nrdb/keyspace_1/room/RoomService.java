package com.pl.nrdb.keyspace_1.room;

import com.pl.nrdb.keyspace_1.room.exceptions.RoomAlreadyExistException;
import com.pl.nrdb.keyspace_1.room.exceptions.RoomNotFoundException;
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

    public Room addSingleRoom(Integer roomNumber, Boolean isAvailable) {
        checkDuplicateRoom(roomNumber);
        SingleRoom singleRoom = SingleRoom.builder()
                .roomNumber(roomNumber)
                .isAvailable(isAvailable)
                .build();
        return roomRepository.save(singleRoom);
    }

    public Room addDoubleRoom(Integer roomNumber, Boolean isAvailable) {
        checkDuplicateRoom(roomNumber);
        DoubleRoom doubleRoom = DoubleRoom.builder()
                .roomNumber(roomNumber)
                .isAvailable(isAvailable)
                .build();
        return roomRepository.save(doubleRoom);
    }

    public Room addTripleRoom(Integer roomNumber, Boolean isAvailable) {
        checkDuplicateRoom(roomNumber);
        TripleRoom tripleRoom = TripleRoom.builder()
                .roomNumber(roomNumber)
                .isAvailable(isAvailable)
                .build();
        return roomRepository.save(tripleRoom);
    }

    public Room modifyRoom(Integer roomNumber, Boolean isAvailable) {
        Room singleRoom = roomRepository.findByRoomNumber(roomNumber).orElseThrow(() -> new RoomNotFoundException(roomNumber));
        if (!singleRoom.getRoomNumber().equals(roomNumber) || !singleRoom.getIsAvailable().equals(isAvailable)) {
            singleRoom.setRoomNumber(roomNumber);
            singleRoom.setIsAvailable(isAvailable);
            roomRepository.save(singleRoom);
        }
        return singleRoom;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    private void deleteRoom(Integer roomNumber) {
        roomRepository.delete(fetchRoom(roomNumber));
    }
}
