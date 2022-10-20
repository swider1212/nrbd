package com.pl.nrdb;

import lombok.Getter;

@Getter
public class NrdbException extends RuntimeException{

    protected NrdbException(String message) {
        super(message);
    }
}
