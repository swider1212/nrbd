package com.pl.nrdb;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private Integer id;

    @Setter
    @NotNull
    private Integer roomNumber;

    @Setter
    @NotNull
    private Boolean isAvailable = true;

}
