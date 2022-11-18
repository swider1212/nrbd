package com.pl.nrdb.room;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rooms")
@TypeAlias("doubleroom")
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
