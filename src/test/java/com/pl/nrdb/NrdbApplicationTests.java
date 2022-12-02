package com.pl.nrdb;

import com.pl.nrdb.client.Client;
import com.pl.nrdb.client.ClientRepository;
import com.pl.nrdb.client.ClientService;
import com.pl.nrdb.idCard.IdCard;
import com.pl.nrdb.idCard.IdCardRepository;
import com.pl.nrdb.idCard.IdCardService;
import com.pl.nrdb.redis.repository.RentRedisRepository;
import com.pl.nrdb.redis.service.RentRedisService;
import com.pl.nrdb.room.RoomRepository;
import com.pl.nrdb.room.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NrdbApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void addRoomTest() {
        roomService = new RoomService(roomRepository);
        roomService.addSingleRoom(1, false);
        roomService.addDoubleRoom(2, true);
    }

    private RentRedisService rentRedisService;
    @Autowired
    private RentRedisRepository rentRedisRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    IdCardRepository idCardRepository;


    @Test
    public void addRentTest() {
        IdCard idCard = new IdCard("1", "chuj", "chuj");
        idCardRepository.save(idCard);
        Client client = new Client("1", "chuj", "chuj", "chuj", idCard);
        clientRepository.save(client);
        rentRedisService = new RentRedisService(rentRedisRepository, clientService, roomService);
        rentRedisService.addRent(1.0F,1, "1");
    }
}
