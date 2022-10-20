package com.pl.nrdb.room;

import com.pl.nrdb.NrdbException;

public class RoomAlreadyExistException extends NrdbException {
    public RoomAlreadyExistException(Integer roomNumber) {
        super(String.format("Room is already exist {roomNumber=%s}",
                roomNumber));
    }
}
