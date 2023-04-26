package com.codingchallenge.roomoccupancy;

import com.codingchallenge.roomoccupancy.data.RoomAvailability;
import com.codingchallenge.roomoccupancy.data.RoomOccupancy;
import com.codingchallenge.roomoccupancy.services.RoomManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoomManagerTest {

    @Autowired
    private RoomManager roomManager;

    @Test
    public void testForThreeAvailablePremiumRoomsAndThreeAvailableEconomyRooms() {
        RoomAvailability availability = new RoomAvailability();
        availability.setAvailablePremiumRooms(3);
        availability.setAvailableEconomyRooms(3);
        RoomOccupancy result = roomManager.makeReservation(availability);
        assertEquals(3, result.getPremiumOccupied());
        assertEquals(3, result.getEconomyOccupied());
        assertEquals(738.0, result.getTotalEarningsForPremium());
        assertEquals(167.99, result.getTotalEarningsForEconomy());
        assertEquals(905.99, result.getOverallEarningsForTheNight());
    }

    @Test
    public void testForSevenAvailablePremiumRoomsAndFiveAvailableEconomyRooms() {
        RoomAvailability availability = new RoomAvailability();
        availability.setAvailablePremiumRooms(7);
        availability.setAvailableEconomyRooms(5);
        RoomOccupancy result = roomManager.makeReservation(availability);
        assertEquals(6, result.getPremiumOccupied());
        assertEquals(4, result.getEconomyOccupied());
        assertEquals(1054.0, result.getTotalEarningsForPremium());
        assertEquals(189.99, result.getTotalEarningsForEconomy());
        assertEquals(1243.99, result.getOverallEarningsForTheNight());
    }

    @Test
    public void testForTwoAvailablePremiumRoomsAndSevenAvailableEconomyRooms() {
        RoomAvailability availability = new RoomAvailability();
        availability.setAvailablePremiumRooms(2);
        availability.setAvailableEconomyRooms(7);
        RoomOccupancy result = roomManager.makeReservation(availability);
        assertEquals(2, result.getPremiumOccupied());
        assertEquals(4, result.getEconomyOccupied());
        assertEquals(583, result.getTotalEarningsForPremium());
        assertEquals(189.99, result.getTotalEarningsForEconomy());
        assertEquals(772.99, result.getOverallEarningsForTheNight());
    }

    @Test
    public void testForSevenAvailablePremiumRoomsAndOneAvailableEconomyRooms() {
        RoomAvailability availability = new RoomAvailability();
        availability.setAvailablePremiumRooms(7);
        availability.setAvailableEconomyRooms(1);
        RoomOccupancy result = roomManager.makeReservation(availability);
        assertEquals(7, result.getPremiumOccupied());
        assertEquals(1, result.getEconomyOccupied());
        assertEquals(1153.99, result.getTotalEarningsForPremium());
        assertEquals(45, result.getTotalEarningsForEconomy());
        assertEquals(1198.99, result.getOverallEarningsForTheNight());
    }


}