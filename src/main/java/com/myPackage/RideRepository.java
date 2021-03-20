package com.myPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RideRepository {

    public HashMap<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRides.get(userId);
        if (rideList == null) {
            this.userRides.putIfAbsent(userId, new ArrayList<>(Arrays.asList(rides)));
        }
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }

}