package com.pl.nrdb.idCard;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IdCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 100)
    @Setter
    @NotNull
    private String personalId;

    @Column(length = 100)
    @Setter
    @NotNull
    private String nationality;
}
