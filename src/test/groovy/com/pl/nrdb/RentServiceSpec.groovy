package com.pl.nrdb

import com.pl.nrdb.client.ClientService
import com.pl.nrdb.redis.model.RentRedis
import com.pl.nrdb.redis.repository.RentRedisRepository
import com.pl.nrdb.redis.service.RentRedisService
import com.pl.nrdb.room.Room
import com.pl.nrdb.room.RoomService
import spock.lang.Specification
import spock.lang.Subject

class RentServiceSpec extends Specification {

    def clientService = Mock(ClientService)
    def rentRedisRepository = Mock(RentRedisRepository)
    def roomService = Mock(RoomService)

    @Subject
    def rentRedisService = new RentRedisService(rentRedisRepository, clientService, roomService)

    def "Should return correct rent"() {
        given: "Rent"
        Room room = new Room("1", 1, true)
        RentRedis rentRedis = new RentRedis("1", 1F, null, null)

        and: "necessary mock"
        roomService.fetchRoom(_) >> room
        rentRedisRepository.save(_) >> rentRedis

        when:"addRent() method is called"
        def result = rentRedisService.addRent(1F, 1, null)

        then:
        noExceptionThrown()
        result == rentRedis
    }

    def "Should correctly delete rent"() {
        given: "Rent"
        def roomNumber = 1
        def clientId = "1"
        def rentRedisWIthId = buildRentWithId("1")

        and: "necessary mock"
        rentRedisRepository.findByRoomRoomNumberAndClientId(roomNumber, clientId) >> Optional.of(rentRedisWIthId)
        rentRedisRepository.delete(rentRedisWIthId)

        when:"delete rent with id 1"
        rentRedisService.endRent(roomNumber, clientId)

        then: "no exception thrown"
        noExceptionThrown()
    }


    def buildRentWithId(id) {
        RentRedis.builder()
            .id(id)
            .rentTotalCost(1F)
            .room()
            .client()
            .build()
    }
}