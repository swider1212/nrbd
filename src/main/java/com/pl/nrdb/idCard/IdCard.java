package com.pl.nrdb.idCard;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "idcards")
public class IdCard {

    @Id
    private String id;

    @Setter
    @NotNull
    private String personalId;

    @Setter
    @NotNull
    private String nationality;
}
