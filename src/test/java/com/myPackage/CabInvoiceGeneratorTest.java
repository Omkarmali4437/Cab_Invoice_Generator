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
        Ride[] rides={new Ride(2.0,5),
        new Ride(0.1,2)};

        double totalFare=cabInvoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,totalFare,0.0);
    }


}
