package com.pl.nrdb.rent;

import com.pl.nrdb.NrdbException;

public class RentNotFoundException extends NrdbException {
    public RentNotFoundException(Integer rentNumber) {
        super(String.format("Room is not found in database {rentNumber=%s}",
                rentNumber));
    }
}
