package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class) public class DeveloperProperties {
  public static final String DEVELOPER_NAME = "Pedro";

  @Property
  public void numberOfMaxibonsCannotBeNegative(int numberOfMaxibons) {
    Developer developer = new Developer(DEVELOPER_NAME, numberOfMaxibons);
    assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    System.out.println(developer.toString());
  }
}
