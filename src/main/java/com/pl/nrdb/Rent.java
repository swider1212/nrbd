package com.pl.nrdb;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rent {

    private Integer id;

    @Setter
    @NotNull
    private Integer rentId;

    @Setter
    @NotNull
    private Float rentTotalCost;

    private Client client;

    private Room room;
}
