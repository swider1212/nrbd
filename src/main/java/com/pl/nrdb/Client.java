package com.pl.nrdb;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Integer id;

    @Setter
    @NotNull
    private String firstName;

    @Setter
    @NotNull
    private String lastName;

    @Setter
    @NotNull
    private String phoneNumber;

    @Setter
    @NotNull
    private Boolean currentClient = false;

    IdCard idCard;
}
