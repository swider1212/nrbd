package com.pl.nrdb.room;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("1")
public class SingleRoom extends Room {

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer basePrice = 170;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer capacity = 1;

    @Builder
    public SingleRoom(Integer id, Integer roomNumber, Boolean isAvailable, Integer basePrice, Integer capacity) {
        super(id, roomNumber, isAvailable);
        this.basePrice = basePrice;
        this.capacity = capacity;
    }
}
