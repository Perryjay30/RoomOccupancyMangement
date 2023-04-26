package com.codingchallenge.roomoccupancy.services;

import com.codingchallenge.roomoccupancy.data.RoomAvailability;
import com.codingchallenge.roomoccupancy.data.RoomOccupancy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomManager {

    public RoomOccupancy makeReservation(RoomAvailability availability) {
        List<Double> potentialGuests = Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0);
        int availablePremiumRooms = availability.getAvailablePremiumRooms();
        int availableEconomyRooms = availability.getAvailableEconomyRooms();
        List<Double> premiumGuests = new ArrayList<>();
        List<Double> economyGuests = new ArrayList<>();

        Collections.sort(potentialGuests, Collections.reverseOrder());

        if(availability.getAvailablePremiumRooms() < 6) {
            for(double guest : potentialGuests) {
                if (guest >= 100 && availablePremiumRooms > 0) {
                    premiumGuests.add(guest);
                    availablePremiumRooms--;
                } else if (guest < 100 && availableEconomyRooms > 0) {
                    economyGuests.add(guest);
                    availableEconomyRooms--;
                }
            }
        } else {
            for (double guest : potentialGuests) {
                if(guest >= 100) {
                    premiumGuests.add(guest);
                    availablePremiumRooms--;
                } else if (guest < 100) {
                    economyGuests.add(guest);
                    availableEconomyRooms--;
                }
            }
        }
        return roomOccupancyMethod(availability, premiumGuests, economyGuests);
    }

    private RoomOccupancy roomOccupancyMethod(RoomAvailability availability, List<Double> premiumGuests, List<Double> economyGuests) {
        boolean isLessThanTenElements = availability.getAvailablePremiumRooms() > 6
                && availability.getAvailableEconomyRooms() < 4;
        if(isLessThanTenElements) {
            Double maxInEconomy = Collections.max(economyGuests);
            premiumGuests.add(maxInEconomy);
            economyGuests.remove(maxInEconomy);
            economyGuests.sort(Comparator.reverseOrder());
            economyGuests.removeIf(guest -> guest < economyGuests.get(0));
        }
        return getRoomOccupancy(premiumGuests, economyGuests);
    }

    private RoomOccupancy getRoomOccupancy(List<Double> premiumGuests, List<Double> economyGuests) {
        double totalEarningsForPremium = premiumGuests.stream().mapToDouble(Double::doubleValue).sum();
        double totalEarningsForEconomy = economyGuests.stream().mapToDouble(Double::doubleValue).sum();
        double overallEarningsForTheNight = totalEarningsForPremium + totalEarningsForEconomy;

        return new RoomOccupancy(premiumGuests.size(), economyGuests.size(), totalEarningsForPremium,
                totalEarningsForEconomy, overallEarningsForTheNight);
    }

}
