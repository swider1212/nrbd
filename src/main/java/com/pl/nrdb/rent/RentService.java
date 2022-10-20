package com.pl.nrdb.rent;

import com.pl.nrdb.client.ClientService;
import com.pl.nrdb.room.RoomIsNotAvailableException;
import com.pl.nrdb.room.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentService {
    private final RentRepository rentRepository;
    private final ClientService clientService;
    private final RoomService roomService;

    public Rent fetchRent(Integer roomNumber, Integer clientId) {
        return rentRepository.findByRoomRoomNumberAndClientId(roomNumber, clientId).orElseThrow(() -> new RentNotFoundException(roomNumber, clientId));
    }

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    private void endRent(Integer roomNumber, Integer clientId) {
        rentRepository.delete(rentRepository.findByRoomRoomNumberAndClientId(roomNumber, clientId).orElseThrow(() -> new RentNotFoundException(roomNumber, clientId)));
    }

    private Rent addRent(Float rentTotalCost, Integer roomNumber, Integer clientId) {
        checkDuplicate(roomNumber, clientId);
        isRoomAvailable(roomNumber);
        return rentRepository.save(Rent.builder()
                .client(clientService.fetchClient(clientId))
                .room(roomService.fetchRoom(roomNumber))
                .rentTotalCost(rentTotalCost)
                .build());
    }

    private void checkDuplicate(Integer roomNumber, Integer clientId) {
        if (rentRepository.existsByRoomRoomNumberAndClientId(roomNumber, clientId)) {
            throw new RentAlreadyExistException(roomNumber, clientId);
        }
    }

    private void isRoomAvailable(Integer roomNumber) {
        if (roomService.fetchRoom(roomNumber).getIsAvailable()) {
            throw new RoomIsNotAvailableException(roomNumber);
        }
    }

    private void isRentExist(Integer roomNumber, Integer clientId) {
        if (!rentRepository.existsByRoomRoomNumberAndClientId(roomNumber, clientId)) {
            throw new RentNotFoundException(roomNumber, clientId);
        }
    }
}
