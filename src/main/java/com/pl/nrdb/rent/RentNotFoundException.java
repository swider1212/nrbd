package com.pl.nrdb.rent;

import com.pl.nrdb.NrdbException;

public class RentNotFoundException extends NrdbException {
    public RentNotFoundException(Integer roomNumber, Integer clientId) {
        super(String.format("Rent is not found in database {roomNumber=%s, clientId=&s}",
                roomNumber, clientId));
    }
}
