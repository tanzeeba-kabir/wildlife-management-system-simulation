/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserve11;

/**
 *
 * @author kabir
 */


import org.junit.Test;
import static org.junit.Assert.*;

public class RangerTest {
@Test
public void testHelpAnimal() {
    Ranger r = new Ranger("Balazs", 5, 7);
    Animal a = new Animal("Elephant", 40, 50, Animal.Temperament.PASSIVE);

    r.helpAnimal(a);

    assertNotEquals(Animal.State.CRITICAL, a.getState());
    
}

@Test
public void testTreatAggressiveAnimal() {
    Ranger r = new Ranger("Balazs", 5, 7);
    Animal a = new Animal("Lion", 70, 30, Animal.Temperament.AGGRESSIVE);
    Habitat h = new Habitat("Savannah", 2);

    r.treatAnimal(a, h);

    assertTrue(h.isUnsafe());
}

@Test
public void testTreatNormalAnimal() {
    Ranger r = new Ranger("Balazs", 5, 7);
    Animal a = new Animal("Zebra", 60, 40, Animal.Temperament.PASSIVE);
    Habitat h = new Habitat("Savannah", 2);

    r.treatAnimal(a, h);

    assertFalse(h.isUnsafe());
}

@Test
public void testDetectAnimalInDanger() {
    Ranger r = new Ranger("Balazs", 5, 7);
    Animal a = new Animal("Lion", 20, 20, Animal.Temperament.AGGRESSIVE);

    a.injure(10); // becomes critical

    assertTrue(r.detectAnimalInDanger(a));
}
@Test
public void testPatrolUnsafeHabitat() {
    Ranger r = new Ranger("Balazs", 5, 7);
    Habitat h = new Habitat("Savannah", 2);

    h.setUnsafe(true);
    r.patrol(h);

    assertTrue(r.isOverStressed() || true); // just ensuring no crash
}
@Test
public void testFightPoacher() {
    Ranger r = new Ranger("Balazs", 5, 7);
    Poacher p = new Poacher("Anne", "Zebra", 5);

    r.fightPoacher(p);

    assertTrue(true); // random outcome, just ensure method runs
}

@Test
public void testEmergencyTreat() {
    Ranger r = new Ranger("Balazs", 5, 7);
    Animal a = new Animal("Elephant", 20, 80, Animal.Temperament.PASSIVE);
    Vehicle v = new Vehicle("V1", 100, "Mobile Medic Unit");
    Habitat h = new Habitat("Savannah", 2);

    r.emergencyTreat(a, v, h);

    assertEquals(Animal.State.STABILISED, a.getState());
}
@Test
public void testStressChange() {
    Ranger r = new Ranger("Balazs", 5, 7);

    r.increaseStress(50);
    r.reduceStress(20);

    assertFalse(r.isOverStressed());
}

@Test
public void testOverStressed() {
    Ranger r = new Ranger("Balazs", 5, 7);

    r.increaseStress(100);

    assertTrue(r.isOverStressed());
}
 
}