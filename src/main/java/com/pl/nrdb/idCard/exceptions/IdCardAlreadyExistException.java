package com.pl.nrdb.idCard.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class IdCardAlreadyExistException extends NrdbException {

    public IdCardAlreadyExistException(String personalId, String nationality) {
        super(String.format("Id card is already in database {personalId=%s, nationality=$s}",
                personalId, nationality));
    }
}
