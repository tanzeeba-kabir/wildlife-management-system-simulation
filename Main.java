/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reserve11;

/**
 *
 * @author kabir
 */
public class Main {

    public static void main(String[] args) {

        // Create objects
        Animal a1 = new Animal("Elephant", 60, 30, Animal.Temperament.DEFENSIVE);
        Animal a2 = new Animal("Lion", 40, 50, Animal.Temperament.AGGRESSIVE);

        Ranger r1 = new Ranger("Balazs", 5, 7);
        Poacher p1 = new Poacher("Anne", "Elephant", 7);

        Habitat h1 = new Habitat("Savannah", 3);
         // Add animals to habitat
        h1.addAnimal(a1);
        h1.addAnimal(a2);
        
        // Create reserve
        Reserve reserve = new Reserve();
        reserve.addHabitat(h1);
        reserve.addRanger(r1);
        reserve.addPoacher(p1);

        // Scenario interactions
        r1.treatAnimal(a2, h1);   // aggressive animal scenario
        r1.helpAnimal(a1);
        r1.fightPoacher(p1);
         
        
        
        // Poacher attacks habitat → animals get injured, habitat unsafe
           h1.poacherAttack();

          // Ranger responds after attack
           r1.treatAnimal(a1, h1);
       
        
        // Run simulation
        reserve.simulateDay();
        
    // use vehicles     
Vehicle v1 = new Vehicle("V1", 100, "Mobile Medic Unit");

r1.emergencyTreat(a1, v1, h1);
    }
}