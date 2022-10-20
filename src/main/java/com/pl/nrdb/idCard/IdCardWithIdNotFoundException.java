package com.pl.nrdb.idCard;

import com.pl.nrdb.NrdbException;

public class IdCardWithIdNotFoundException extends NrdbException {
    public IdCardWithIdNotFoundException(Integer id) {
        super(String.format("Id card is already in database {id=%s}",
                id));
    }
}
