/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserve11;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author kabir
 */
public class HabitatTest {
  @Test
public void testAddAnimal() {
    Habitat h = new Habitat("Savannah", 2);
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);

    h.addAnimal(a);

    assertEquals(1, h.getAnimals().size());
}
@Test
public void testAddAnimalWhenFull() {
    Habitat h = new Habitat("Savannah", 1);
    Animal a1 = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);
    Animal a2 = new Animal("Lion", 70, 30, Animal.Temperament.AGGRESSIVE);

    h.addAnimal(a1);
    h.addAnimal(a2);

    assertEquals(1, h.getAnimals().size());
}

@Test
public void testRemoveAnimal() {
    Habitat h = new Habitat("Savannah", 2);
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);

    h.addAnimal(a);
    h.removeAnimal(a);

    assertEquals(0, h.getAnimals().size());
}

@Test
public void testPoacherAttack() {
    Habitat h = new Habitat("Savannah", 2);
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);

    h.addAnimal(a);
    h.poacherAttack();

    assertTrue(h.isUnsafe());
}
@Test
public void testSetUnsafe() {
    Habitat h = new Habitat("Savannah", 2);

    h.setUnsafe(true);

    assertTrue(h.isUnsafe());
}

@Test
public void testGetAnimals() {
    Habitat h = new Habitat("Savannah", 2);
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);

    h.addAnimal(a);

    assertNotNull(h.getAnimals());
}

@Test
public void testGetName() {
    Habitat h = new Habitat("Savannah", 2);

    assertEquals("Savannah", h.getName());
}

}
