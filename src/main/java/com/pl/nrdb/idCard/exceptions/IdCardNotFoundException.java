package com.pl.nrdb.idCard.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class IdCardNotFoundException extends NrdbException {

    public IdCardNotFoundException(String personalId, String nationality) {
        super(String.format("Id card is already in database {personalId=%s, nationality=$s}",
                personalId, nationality));
    }
}
