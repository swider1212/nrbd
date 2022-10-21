package com.pl.nrdb.room.exceptions;

import com.pl.nrdb.exceptions.NrdbException;

public class RoomIsNotAvailableException extends NrdbException {
    public RoomIsNotAvailableException(Integer roomNumber) {
        super(String.format("Room is not available right now {roomNumber=%s}",
                roomNumber));
    }
}
