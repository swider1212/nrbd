package com.pl.nrdb;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IdCard {

    private Integer id;

    @Setter
    @NotNull
    private String personalId;

    @Setter
    @NotNull
    private String nationality;
}
