package com.pl.nrdb.idCard;

import com.pl.nrdb.NrdbException;

public class IdCardNotFoundException extends NrdbException {

    public IdCardNotFoundException(String personalId, String nationality) {
        super(String.format("Id card is already in database {personalId=%s, nationality=$s}",
                personalId, nationality));
    }
}
