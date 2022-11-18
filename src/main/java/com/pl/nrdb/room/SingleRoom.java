package com.pl.nrdb.room;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rooms")
@TypeAlias("singleroom")
public class SingleRoom extends Room {

    @Setter
    @NotNull
    private Integer basePrice = 170;

    @Setter
    @NotNull
    private Integer capacity = 1;

    @Builder
    public SingleRoom(String id, Integer roomNumber, Boolean isAvailable, Integer basePrice, Integer capacity) {
        super(id, roomNumber, isAvailable);
        this.basePrice = basePrice;
        this.capacity = capacity;
    }
}
