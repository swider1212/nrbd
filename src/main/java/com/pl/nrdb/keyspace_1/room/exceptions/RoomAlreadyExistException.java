package com.pl.nrdb.keyspace_1.room.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class RoomAlreadyExistException extends NrdbException {
    public RoomAlreadyExistException(Integer roomNumber) {
        super(String.format("Room is already exist {roomNumber=%s}",
                roomNumber));
    }
}
