package com.myPackage;

public enum CabRide {

    Normal(10.0,1.0,5.0),
    PREMIUM(15.0,2.0,20.0);

    private final double costperkm;
    private final double costpermin;
    private final double minfare;

    CabRide(double costperkm, double costpermin, double minfare){
        this.costperkm=costperkm;
        this.costpermin=costpermin;
        this.minfare=minfare;
    }

    public double calcCostOfCabRide(Ride ride) {
        double rideCost = ride.distance * costperkm + ride.time * costpermin;
        return rideCost;
    }

}
