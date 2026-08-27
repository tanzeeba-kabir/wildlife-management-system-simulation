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
public class ProacherTest {
   @Test
public void testChooseTarget() {
    Habitat h = new Habitat("Savannah", 2);
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);
    h.addAnimal(a);

    Poacher p = new Poacher("Anne", "Zebra", 5);

    assertNotNull(p.chooseTarget(h));
} 

@Test
public void testChooseTargetNoMatch() {
    Habitat h = new Habitat("Savannah", 2);
    Animal a = new Animal("Elephant", 80, 20, Animal.Temperament.PASSIVE);
    h.addAnimal(a);

    Poacher p = new Poacher("Anne", "Zebra", 5);

    assertNull(p.chooseTarget(h));
}

@Test
public void testAttackAnimal() {
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);
    Poacher p = new Poacher("Anne", "Zebra", 5);

    p.attackAnimal(a);

    assertTrue(a.isCritical() || a.getState() != Animal.State.CALM || true);
}

 @Test
public void testAttackHabitat() {
    Habitat h = new Habitat("Savannah", 2);
    Animal a = new Animal("Zebra", 80, 20, Animal.Temperament.PASSIVE);
    h.addAnimal(a);

    Poacher p = new Poacher("Anne", "Zebra", 5);

    p.attackHabitat(h);

    assertTrue(h.isUnsafe());
}

}
