package com.pl.nrdb.idCard;

import com.pl.nrdb.NrdbException;

public class IdCardAlreadyExistException extends NrdbException {

    public IdCardAlreadyExistException(String personalId, String nationality) {
        super(String.format("Id card is already in database {personalId=%s, nationality=$s}",
                personalId, nationality));
    }
}
