package com.pl.nrdb.room;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SingleRoom extends Room{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer BasePrice = 170;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer Capacity = 1;
}
