package com.pl.nrdb.exceptions;

import lombok.Getter;

@Getter
public class NrdbException extends RuntimeException {

    protected NrdbException(String message) {
        super(message);
    }
}
