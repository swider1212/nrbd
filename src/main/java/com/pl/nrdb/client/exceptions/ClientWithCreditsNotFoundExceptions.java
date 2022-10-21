package com.pl.nrdb.client.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class ClientWithCreditsNotFoundExceptions extends NrdbException {
    public ClientWithCreditsNotFoundExceptions(String firstName, String lastName, String phoneNumber) {
        super(String.format("Client is not found in database {firstName=%s, lastName=%s, phoneNumber=%s}",
                firstName, lastName, phoneNumber));
    }
}
