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

public class VehicleTest {

    @Test
    public void testRefuel() {
        Vehicle v = new Vehicle("V1", 20, "Medic");

        v.refuel();

        // we assume refuel sets to 100
        assertEquals(100, v.getFuelLevel());
    }
    
  @Test
public void testDeployToHabitat() {
    Vehicle v = new Vehicle("V1", 100, "Medic");
    Habitat h = new Habitat("Savannah", 2);

    v.deployToHabitat(h);

    assertTrue(v.getFuelLevel() < 100);
}
@Test
public void testDeployNoFuel() {
    Vehicle v = new Vehicle("V1", 0, "Medic");
    Habitat h = new Habitat("Savannah", 2);

    v.deployToHabitat(h);

    assertEquals(0, v.getFuelLevel());
}

@Test
public void testUseEquipment() {
    Vehicle v = new Vehicle("V1", 100, "Medic");

    v.useEquipment();

    assertTrue(true); // just ensures no crash
}

@Test
public void testHasFuel() {
    Vehicle v = new Vehicle("V1", 50, "Medic");

    assertTrue(v.hasFuel());
}

@Test
public void testConsumeFuel() {
    Vehicle v = new Vehicle("V1", 100, "Medic");

    v.consumeFuel(30);

    assertEquals(70, v.getFuelLevel());
}

@Test
public void testTransportRanger() {
    Vehicle v = new Vehicle("V1", 100, "Medic");
    Ranger r = new Ranger("Balazs", 5, 7);
    Habitat h = new Habitat("Savannah", 2);

    v.transportRanger(r, h);

    assertTrue(v.getFuelLevel() < 100);
}

}
