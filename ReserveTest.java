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
public class ReserveTest {
    @Test
public void testSimulateDay() {
    Reserve r = new Reserve();

    Habitat h = new Habitat("Savannah", 2);
    Ranger ranger = new Ranger("Balazs", 5, 7);
    Poacher p = new Poacher("Anne", "Zebra", 5);

    r.addHabitat(h);
    r.addRanger(ranger);
    r.addPoacher(p);

    r.simulateDay();

    assertTrue(true); // just ensure no crash
}

@Test
public void testReportStatus() {
    Reserve r = new Reserve();

    Habitat h = new Habitat("Savannah", 2);
    r.addHabitat(h);

    r.reportStatus();

    assertTrue(true);
}

}
