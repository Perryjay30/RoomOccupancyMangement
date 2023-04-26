package com.codingchallenge.roomoccupancy.controller;

import com.codingchallenge.roomoccupancy.data.RoomAvailability;
import com.codingchallenge.roomoccupancy.services.RoomManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomManagerController {

    private final RoomManager roomManager;

    public RoomManagerController(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @PostMapping("/makeReservation")
    public ResponseEntity<?> bookRoom(@RequestBody RoomAvailability availability) {
        return ResponseEntity.ok(roomManager.makeReservation(availability));
    }
}
