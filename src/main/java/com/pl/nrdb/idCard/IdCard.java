package com.pl.nrdb.idCard;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class IdCard {

    @PrimaryKey
    private String id;

    @Setter
    @NotNull
    private String personalId;

    @Setter
    @NotNull
    private String nationality;
}
