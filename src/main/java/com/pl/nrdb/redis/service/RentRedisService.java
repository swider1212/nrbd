package com.pl.nrdb.redis.service;

import com.pl.nrdb.client.ClientService;
import com.pl.nrdb.redis.model.RentRedis;
import com.pl.nrdb.redis.repository.RentRedisRepository;
import com.pl.nrdb.rent.exceptions.RentAlreadyExistException;
import com.pl.nrdb.rent.exceptions.RentNotFoundException;
import com.pl.nrdb.room.exceptions.RoomIsNotAvailableException;
import com.pl.nrdb.room.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentRedisService {
    private final RentRedisRepository rentRedisRepository;
    private final ClientService clientService;
    private final RoomService roomService;

    @Cacheable (value = "rent", key = "#roomNumber")
    public RentRedis fetchRent(Integer roomNumber, String clientId) {
        return rentRedisRepository.findByRoomRoomNumberAndClientId(roomNumber, clientId).orElseThrow(() -> new RentNotFoundException(roomNumber, clientId));
    }

    @Cacheable (value = "rent")
    public Iterable<RentRedis> getAllRents() {
        return rentRedisRepository.findAll();
    }

    @CacheEvict(value = "rent", key = "#roomNumber")
    public void endRent(Integer roomNumber, String clientId) {
        rentRedisRepository.delete(rentRedisRepository.findByRoomRoomNumberAndClientId(roomNumber, clientId).orElseThrow(() -> new RentNotFoundException(roomNumber, clientId)));
    }

    @CachePut(value = "rent", key = "#roomNumber")
    public RentRedis addRent(Float rentTotalCost, Integer roomNumber, String clientId) {
        checkDuplicate(roomNumber, clientId);
        isRoomAvailable(roomNumber);
        roomService.fetchRoom(roomNumber).setIsAvailable(true);
        return rentRedisRepository.save(RentRedis.builder()
                .client(clientService.fetchClient(clientId))
                .room(roomService.fetchRoom(roomNumber))
                .rentTotalCost(rentTotalCost)
                .build());

    }

    private void checkDuplicate(Integer roomNumber, String clientId) {
        if (rentRedisRepository.existsByRoomRoomNumberAndClientId(roomNumber, clientId)) {
            throw new RentAlreadyExistException(roomNumber, clientId);
        }
    }

    private void isRoomAvailable(Integer roomNumber) {
        if (!roomService.fetchRoom(roomNumber).getIsAvailable()) {
            throw new RoomIsNotAvailableException(roomNumber);
        }
    }

    @CachePut(value = "rent", key = "#roomNumber")
    public RentRedis modifyRent(Float rentTotalCost, Integer roomNumber, String clientId, String rentId) {
        RentRedis rentRedis = rentRedisRepository.findById(rentId).orElseThrow(() -> new RentNotFoundException(roomNumber, clientId));
        if (!rentRedis.getClient().equals(clientService.fetchClient(clientId)) || !rentRedis.getRentTotalCost().equals(rentTotalCost) || !rentRedis.getRoom().equals(roomService.fetchRoom(roomNumber))) {
            rentRedis.setClient(clientService.fetchClient(clientId));
            rentRedis.setRentTotalCost(rentTotalCost);
            rentRedis.setRoom(roomService.fetchRoom(roomNumber));
            rentRedisRepository.save(rentRedis);
        }
        return rentRedis;
    }
}
