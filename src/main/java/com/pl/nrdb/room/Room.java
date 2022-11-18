package com.pl.nrdb.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rooms")
public class Room {

    @Id
    private String id;

    @Setter
    @NotNull
    private Integer roomNumber;

    @Setter
    @NotNull
    private Boolean isAvailable = true;

}
