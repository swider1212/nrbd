package com.pl.nrdb.keyspace_1.rent.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class RentNotFoundException extends NrdbException {
    public RentNotFoundException(Integer roomNumber, String clientId) {
        super(String.format("Rent is not found in database {roomNumber=%d, clientId=&d}",
                roomNumber, clientId));
    }
}
