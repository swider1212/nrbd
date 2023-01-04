package com.pl.nrdb.keyspace_1.room;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class TripleRoom extends Room {

    @Setter
    @NotNull
    private Integer basePrice = 350;

    @Setter
    @NotNull
    private Integer capacity = 3;

    @Builder
    public TripleRoom(String id, Integer roomNumber, Boolean isAvailable, Integer basePrice, Integer capacity) {
        super(id, roomNumber, isAvailable);
        this.basePrice = basePrice;
        this.capacity = capacity;
    }
}
