package com.pl.nrdb.rent;

import com.pl.nrdb.NrdbException;

public class RentAlreadyExistException extends NrdbException {
    public RentAlreadyExistException(Integer roomNumber, Integer clientId) {
        super(String.format("Rent is already exist {roomNumber=%s, clientId=&s}",
                roomNumber, clientId));
    }
}
