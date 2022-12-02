package com.pl.nrdb.redis.model;

import com.pl.nrdb.client.Client;
import com.pl.nrdb.room.Room;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Rent")
public class RentRedis {

    @Id
    private String id;

    @Setter
    @NotNull
    private Float rentTotalCost;

    @Setter
    private Client client;

    @Setter
    private Room room;
}
