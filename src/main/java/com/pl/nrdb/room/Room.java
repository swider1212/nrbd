package com.pl.nrdb.room;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer roomNumber;

    @Column(length = 100)
    @Setter
    @NotNull
    private Boolean isAvailable = true;

}
