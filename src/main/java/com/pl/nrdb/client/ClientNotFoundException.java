package com.pl.nrdb.client;

import com.pl.nrdb.NrdbException;

public class ClientNotFoundException extends NrdbException {
    public ClientNotFoundException(Integer clientId) {
        super(String.format("Client is not found in database {clientId=%s}",
                clientId));
    }
}
