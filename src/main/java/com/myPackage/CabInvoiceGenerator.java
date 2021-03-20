package com.myPackage;

public class CabInvoiceGenerator {

    private final int  COST_PER_KILOMETER=10;
    private final int COST_PER_MINUTE=1;
    private final double MINIMUM_FARE=5.0;

    public double calculateFare(double distance,int time) {
        double totalFare;
        totalFare=distance*COST_PER_KILOMETER+time*COST_PER_MINUTE;
        if(totalFare<MINIMUM_FARE){
            totalFare=MINIMUM_FARE;
        }
        return totalFare;
    }
}
