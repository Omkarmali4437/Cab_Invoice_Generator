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
    public void to_check_total_fare_if_given_false(){
        double totalFare=cabInvoiceGenerator.calculateFare(0.1,2);
        Assert.assertEquals(5,totalFare,0.0);
    }

}
