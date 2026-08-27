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

public class AnimalTest {

    @Test
    public void testInjure() {
        Animal a = new Animal("Lion", 50, 20, Animal.Temperament.AGGRESSIVE);
        a.injure(30);

        assertEquals(Animal.State.CRITICAL, a.getState());
    }

    @Test
    public void testHeal() {
        Animal a = new Animal("Elephant", 40, 50, Animal.Temperament.DEFENSIVE);
        a.heal(20);

        assertNotEquals(Animal.State.CRITICAL, a.getState());
    }
    
    @Test
public void testAggressiveAnimalAttacks() {
    Animal a = new Animal("Lion", 70, 30, Animal.Temperament.AGGRESSIVE);

    boolean result = a.reactToRanger();

    assertTrue(result);
    assertEquals(Animal.State.ATTACKING, a.getState());
}
@Test
public void testIncreaseStress() {
    Animal a = new Animal("Zebra", 80, 10, Animal.Temperament.PASSIVE);

    a.increaseStress(50);

    assertEquals(Animal.State.ALERTED, a.getState());
}
@Test
public void testDecreaseStress() {
    Animal a = new Animal("Zebra", 80, 60, Animal.Temperament.PASSIVE);

    a.decreaseStress(40);

    assertEquals(Animal.State.CALM, a.getState());
}
@Test
public void testCalmDown() {
    Animal a = new Animal("Zebra", 70, 80, Animal.Temperament.DEFENSIVE);

    a.calmDown();

    assertEquals(Animal.State.CALM, a.getState());
}

@Test
public void testFlee() {
    Animal a = new Animal("Zebra", 70, 60, Animal.Temperament.DEFENSIVE);

    a.flee();

    assertEquals(Animal.State.FLEEING, a.getState());
}
@Test
public void testAttack() {
    Animal a = new Animal("Lion", 70, 40, Animal.Temperament.AGGRESSIVE);

    a.attack();

    assertEquals(Animal.State.ATTACKING, a.getState());
}
@Test
public void testReactToRangerNonAggressive() {
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);

    boolean result = a.reactToRanger();

    assertFalse(result);
    assertEquals(Animal.State.CALM, a.getState());
}
@Test
public void testStabilise() {
    Animal a = new Animal("Elephant", 20, 90, Animal.Temperament.DEFENSIVE);

    a.stabilise();

    assertEquals(Animal.State.STABILISED, a.getState());
}
@Test
public void testIsCritical() {
    Animal a = new Animal("Lion", 50, 20, Animal.Temperament.AGGRESSIVE);

    a.injure(40); // health goes low

    assertTrue(a.isCritical());
}
}