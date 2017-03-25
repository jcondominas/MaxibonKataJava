package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class) public class DeveloperProperties {
  public static final String DEVELOPER_NAME = "Pedro";
  public static final int MIN_MAXIBONS = 0;

  @Property
  public void numberOfMaxibonsCannotBeNegative(String name , int numberOfMaxibons) {
    Developer developer = new Developer(name, numberOfMaxibons);
    assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    System.out.println(developer.toString());
  }

  @Test
  public void developerShouldGrabMaxibons(){
    assertTrue(Karumies.PEDRO.getNumberOfMaxibonsToGrab() == 3);
    assertTrue(Karumies.SERGIO.getNumberOfMaxibonsToGrab() == 2);
    assertTrue(Karumies.JORGE.getNumberOfMaxibonsToGrab() == 1);
    assertTrue(Karumies.DAVIDE.getNumberOfMaxibonsToGrab() >= 0);
    assertTrue(Karumies.ALBERTO.getNumberOfMaxibonsToGrab() == 1);
  }
}
