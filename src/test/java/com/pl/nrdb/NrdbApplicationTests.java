package com.pl.nrdb;

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

    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void addRoomTest() {
        roomService = new RoomService(roomRepository);
        roomService.addSingleRoom(1, false);
        roomService.addDoubleRoom(2, true);
    }
}
