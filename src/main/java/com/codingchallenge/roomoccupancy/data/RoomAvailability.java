package com.codingchallenge.roomoccupancy.data;

import lombok.Data;

import java.util.List;

@Data
public class RoomAvailability {
//    private List<Double> potentialGuests;
    private int availablePremiumRooms;
    private int availableEconomyRooms;
}
