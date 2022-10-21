package com.pl.nrdb.room;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("2")
public class DoubleRoom extends Room {

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer basePrice = 255;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer capacity = 2;

    @Builder
    public DoubleRoom(Integer id, Integer roomNumber, Boolean isAvailable, Integer basePrice, Integer capacity) {
        super(id, roomNumber, isAvailable);
        this.basePrice = basePrice;
        this.capacity = capacity;
    }
}
