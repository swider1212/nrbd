package com.pl.nrdb.redis.repository;

import com.pl.nrdb.redis.model.RentRedis;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RentRedisRepository extends CrudRepository<RentRedis, String> {

    Optional<RentRedis> findByRoomRoomNumberAndClientId(Integer roomNumber, String clientId);

    boolean existsByRoomRoomNumberAndClientId(Integer roomNumber, String clientId);
}
