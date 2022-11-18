package com.pl.nrdb.rent;

import com.pl.nrdb.client.Client;
import com.pl.nrdb.room.Room;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rents")
public class Rent {

    @Id
    private String id;

    @Setter
    @NotNull
    private Float rentTotalCost;

    @Setter
    private Client client;

    @Setter
    private Room room;
}
