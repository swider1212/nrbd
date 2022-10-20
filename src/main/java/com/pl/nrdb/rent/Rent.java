package com.pl.nrdb.rent;

import com.pl.nrdb.client.Client;
import com.pl.nrdb.room.Room;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 100)
    @Setter
    @NotNull
    private Float rentTotalCost;

    private Client client;

    private Room room;
}