package com.pl.nrdb.client;

import com.pl.nrdb.idCard.IdCard;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class Client {

    @Id
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
    IdCard idCard;
}
