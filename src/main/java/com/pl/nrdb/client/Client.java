package com.pl.nrdb.client;

import com.pl.nrdb.idCard.IdCard;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.cassandra.core.mapping.Embedded;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import static org.springframework.data.cassandra.core.mapping.Embedded.OnEmpty.USE_NULL;

@Builder
@Getter
@Table
public class Client {

    @PrimaryKey
    private String id;

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
    @Embedded(onEmpty = USE_NULL)
    IdCard idCard;

    public Client(String id, @NotNull String firstName, @NotNull String lastName, @NotNull String phoneNumber, IdCard idCard) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
    }
}
