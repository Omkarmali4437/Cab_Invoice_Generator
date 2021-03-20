package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cabInvoiceGenerator;
    @Before
    public void setup(){
        cabInvoiceGenerator=new CabInvoiceGenerator();
    }

    @Test
    public void to_check_total_fare_if_given_true(){
        double totalFare=cabInvoiceGenerator.calculateFare(2.0,5);
        Assert.assertEquals(25,totalFare,0.0);
    }

    @Test
    public void to_check_total_fare_if_given_less_return_minimumfare(){
        double totalFare=cabInvoiceGenerator.calculateFare(0.1,2);
        Assert.assertEquals(5,totalFare,0.0);
    }

    @Test
    public void given_Multiple_Rides_Should_Return_TotalFare(){
        Ride[] rides={new Ride(2.0,5,CabRide.Normal),
            new Ride(0.1,2,CabRide.Normal)};

        double totalFare=cabInvoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,totalFare,0.0);
    }

    @Test
    public void given_mutiple_should_return_average_Fare(){
        Ride[] rides={new Ride(2.0,5,CabRide.Normal),
                new Ride(0.1,2,CabRide.Normal)};

        double totalFare=cabInvoiceGenerator.calculateFare(rides);
        int numberofrides=cabInvoiceGenerator.numofRides(rides);
        double averageFare=cabInvoiceGenerator.calculateaverageFarePerRide(rides);

        Assert.assertEquals(30,totalFare,0.0);
        Assert.assertEquals(2,numberofrides);
        Assert.assertEquals(15,averageFare,0.0);
    }

    @Test
    public void adding_UserID_to_Ride_repository(){
        String userId="Omkar";
        Ride[] rides={new Ride(2.0,5,CabRide.Normal),
                new Ride(0.1,2,CabRide.Normal),
                new Ride(1,2,CabRide.Normal)};

        cabInvoiceGenerator.addRides(userId,rides);
        double rideinfo=cabInvoiceGenerator.getRidesInfo(userId);
        int numofRides=cabInvoiceGenerator.numofRides(rides);

        Assert.assertEquals(42,rideinfo,0.0);
        Assert.assertEquals(3,numofRides);
    }

    @Test
    public void adding_Premium_and_Normal_Rides(){
        String userId="Omkar";
        Ride[] rides={new Ride(2.0,5,CabRide.Normal),
                new Ride(0.1,1,CabRide.PREMIUM),
                new Ride(2,2,CabRide.PREMIUM)};
        cabInvoiceGenerator.addRides(userId,rides);
        double rideinfo=cabInvoiceGenerator.getRidesInfo(userId);
        int numofRides=cabInvoiceGenerator.numofRides(rides);

        Assert.assertEquals(62.5,rideinfo,0.0);
        Assert.assertEquals(3,numofRides);
    }

}
