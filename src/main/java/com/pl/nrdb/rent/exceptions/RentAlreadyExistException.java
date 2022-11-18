package com.pl.nrdb.rent.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class RentAlreadyExistException extends NrdbException {
    public RentAlreadyExistException(Integer roomNumber, String clientId) {
        super(String.format("Rent is already exist {roomNumber=%d, clientId=&d}",
                roomNumber, clientId));
    }
}
