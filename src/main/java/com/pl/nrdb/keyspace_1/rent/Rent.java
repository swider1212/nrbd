package com.pl.nrdb.keyspace_1.rent;

import com.pl.nrdb.client.Client;
import com.pl.nrdb.keyspace_1.room.Room;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Rent {

    @PrimaryKey
    private String id;

    @Setter
    @NotNull
    private Float rentTotalCost;

    @Setter
    private Client client;

    @Setter
    private Room room;
}
