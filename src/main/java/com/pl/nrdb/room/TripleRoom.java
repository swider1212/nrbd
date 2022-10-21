package com.pl.nrdb.room;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("3")
public class TripleRoom extends Room {

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer basePrice = 350;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer capacity = 3;

    @Builder
    public TripleRoom(Integer id, Integer roomNumber, Boolean isAvailable, Integer basePrice, Integer capacity) {
        super(id, roomNumber, isAvailable);
        this.basePrice = basePrice;
        this.capacity = capacity;
    }
}
