package com.pl.nrdb.room;

import com.pl.nrdb.NrdbException;

public class RoomNotFoundException extends NrdbException {
    public RoomNotFoundException(Integer roomNumber) {
        super(String.format("Room is not found in database {roomNumber=%s}",
                roomNumber));
    }
}
