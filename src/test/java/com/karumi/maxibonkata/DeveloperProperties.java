package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class) public class DeveloperProperties {
  private KarumiHQs karumiHqs = new KarumiHQs(message->{
  });

  @Property
  public void numberOfMaxibonsCannotBeNegative(String name, int numberOfMaxibons) {
    Developer developer = new Developer(name, numberOfMaxibons);
    assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    System.out.println(developer.toString());
  }

  @Test
  public void developerShouldGrabMaxibons() {
    assertTrue(Karumies.PEDRO.getNumberOfMaxibonsToGrab() == 3);
    assertTrue(Karumies.SERGIO.getNumberOfMaxibonsToGrab() == 2);
    assertTrue(Karumies.JORGE.getNumberOfMaxibonsToGrab() == 1);
    assertTrue(Karumies.DAVIDE.getNumberOfMaxibonsToGrab() >= 0);
    assertTrue(Karumies.ALBERTO.getNumberOfMaxibonsToGrab() == 1);
  }

  @Property
  public void numberOfMaxibonsShouldBeAlwaysMoreThan2(@From(DevelopersGenerator.class) Developer developer) {
    karumiHqs.openFridge(developer);
    assertTrue(karumiHqs.getMaxibonsLeft() >= 2);
    System.out.println(karumiHqs.getMaxibonsLeft());
  }

  @Property
  public void numberOfMaxibonsShouldBeAlwaysMoreThan2WhenDeveloperIsKarumier(@From(KarumiesGenerator.class) Developer developer) {
    karumiHqs.openFridge(developer);
    assertTrue(karumiHqs.getMaxibonsLeft() >= 2);
    System.out.println(karumiHqs.getMaxibonsLeft());
  }

  @Property
  public void numberOfMaxibonsShouldBeAlwaysMoreThan2WhenDeveloperIsKarumiers(List<@From(
  KarumiesGenerator.class) Developer> developers) {
    karumiHqs.openFridge(developers);
    assertTrue(karumiHqs.getMaxibonsLeft() >= 2);
    System.out.println(karumiHqs.getMaxibonsLeft());
  }

  @Property
  public void numberOfMaxibonsShouldBeAlwaysMoreThan2WhenListOfDevelopers(List<@From(
  DevelopersGenerator.class) Developer> developerList) {
    karumiHqs.openFridge(developerList);
    assertTrue(karumiHqs.getMaxibonsLeft() >= 2);
    System.out.println(karumiHqs.getMaxibonsLeft());
  }
}
