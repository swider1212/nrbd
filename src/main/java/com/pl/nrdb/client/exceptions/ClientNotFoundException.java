package com.pl.nrdb.client.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class ClientNotFoundException extends NrdbException {
    public ClientNotFoundException(Integer clientId) {
        super(String.format("Client is not found in database {clientId=%s}",
                clientId));
    }
}
