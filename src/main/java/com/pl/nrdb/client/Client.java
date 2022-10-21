package com.pl.nrdb.client;

import com.pl.nrdb.idCard.IdCard;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 100)
    @Setter
    @NotNull
    private String firstName;

    @Column(length = 100)
    @Setter
    @NotNull
    private String lastName;

    @Column(length = 100)
    @Setter
    @NotNull
    private String phoneNumber;

    @Setter
    @OneToOne
    IdCard idCard;
}
