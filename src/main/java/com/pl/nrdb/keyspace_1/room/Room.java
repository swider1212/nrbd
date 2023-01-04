package com.pl.nrdb.keyspace_1.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Room {

    @PrimaryKey
    private String id;

    @Setter
    @NotNull
    private Integer roomNumber;

    @Setter
    @NotNull
    private Boolean isAvailable = true;

}
