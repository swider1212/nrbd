package com.pl.nrdb.idCard.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class IdCardWithIdNotFoundException extends NrdbException {
    public IdCardWithIdNotFoundException(Integer id) {
        super(String.format("Id card is already in database {id=%s}",
                id));
    }
}
