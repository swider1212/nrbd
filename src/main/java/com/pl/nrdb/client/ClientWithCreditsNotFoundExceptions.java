package com.pl.nrdb.client;

import com.pl.nrdb.NrdbException;

public class ClientWithCreditsNotFoundExceptions extends NrdbException {
    public ClientWithCreditsNotFoundExceptions(String firstName, String lastName, String phoneNumber) {
        super(String.format("Client is not found in database {firstName=%s, lastName=%s, phoneNumber=%s}",
                firstName, lastName, phoneNumber));
    }
}
