package com.pl.nrdb.client;

import com.pl.nrdb.NrdbException;

public class ClientAlreadyExistException extends NrdbException {

    public ClientAlreadyExistException(Integer clientId) {
        super(String.format("Client is already in database {clientId=%s}",
                clientId));
    }
}
