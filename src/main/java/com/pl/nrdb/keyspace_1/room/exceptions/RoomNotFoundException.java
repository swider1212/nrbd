package com.pl.nrdb.keyspace_1.room.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class RoomNotFoundException extends NrdbException {
    public RoomNotFoundException(Integer roomNumber) {
        super(String.format("Room is not found in database {roomNumber=%s}",
                roomNumber));
    }
}
