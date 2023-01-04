package com.pl.nrdb.keyspace_1.room;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class DoubleRoom extends Room {

    @Setter
    @NotNull
    private Integer basePrice = 255;

    @Setter
    @NotNull
    private Integer capacity = 2;

    @Builder
    public DoubleRoom(String id, Integer roomNumber, Boolean isAvailable, Integer basePrice, Integer capacity) {
        super(id, roomNumber, isAvailable);
        this.basePrice = basePrice;
        this.capacity = capacity;
    }
}
