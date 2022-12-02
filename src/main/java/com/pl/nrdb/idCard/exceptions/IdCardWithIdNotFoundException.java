package com.pl.nrdb.idCard.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class IdCardWithIdNotFoundException extends NrdbException {
    public IdCardWithIdNotFoundException(String id) {
        super(String.format("Id card is not in database {id=%s}",
                id));
    }
}
