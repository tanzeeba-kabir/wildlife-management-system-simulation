/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserve11;

/**
 *
 * @author kabir
 */
/**
 * Represents a ranger who protects animals habitat areas and fights poacher.
 */


    
public class Ranger {

    /**
     * Creates a new Ranger.
     * 
     * @param name the name of the ranger
     * @param experience the experience level of the ranger
     * @param efficiency the efficiency of the ranger
     */
    private final String name;  //final is used to make fields immutable after initialization ensuring they cannot be modified later
    private final int experience;
    private final int efficiency;
    private int stress;

    public Ranger(String name, int experience, int efficiency) {
        this.name = name;
        this.experience = experience;
        this.efficiency = efficiency;
        this.stress = 0;
    }
    public String getName() {
    return name;
}

  
     /**
     * Patrols a habitat and checks for danger.
     * 
     * @param h the habitat to patrol
     */
    public void patrol(Habitat h) {
        System.out.println(name + " is patrolling habitat " + h.getName());

        if (h.isUnsafe()) {
            System.out.println(name + " found danger in habitat!");
            increaseStress(10);
        }
    }

    
    /**
     * Detects if an animal is in danger.
     * 
     * @param a the animal to check
     * @return true if the animal is in danger, false otherwise
     */
    public boolean detectAnimalInDanger(Animal a) {
        return a.isCritical() || a.getState() == Animal.State.ALERTED;
    }

    /**
     * Helps an animal by healing it.
     * 
     * @param a the animal to assist
     */
    public void helpAnimal(Animal a) {
        a.heal(30);
        increaseStress(10);
        System.out.println(name + " helped " + a.getSpecies());
    }

    
    /**
     * Attempts to treat an animal.
     * 
     * @param a the animal to treat
     * @param h the habitat where the interaction occurs
     */
    public void treatAnimal(Animal a, Habitat h) {
        System.out.println(name + " tries to treat " + a.getSpecies());

        if (isOverStressed()) {
            System.out.println(name + " is too stressed to treat safely!");
            return;
        }

        if (a.reactToRanger()) {
            System.out.println(a.getSpecies() + " attacked " + name + "!");
            increaseStress(20);

            System.out.println(name + " retreats and calls for help!");
            h.setUnsafe(true);
        } else {
            helpAnimal(a);
        }
    }
/**
     * Ranger fights a poacher.
     * 
     * @param p the poacher to fight
     */
    public void fightPoacher(Poacher p) {
        double rangerPower = Math.random() * (efficiency + experience);
        double poacherPower = Math.random() * p.getDangerLevel(); // the question asks to set powers to random

        if (rangerPower > poacherPower) {
            System.out.println( name + "  n/defeated poacher " + p.getName());
        } else {
            System.out.println(name + " n/lost to poacher " + p.getName());
            increaseStress(20);
        }
    }

     /**
     * Increases stress level of ranger 
     * 
     * @param amount the amount to increase stress 
     */
   public void increaseStress(int amount) {
    stress = Math.min(100, stress + amount);
}

    /**
     * Reduces stress level.
     * 
     * @param amount the amount to reduce stress by
     */
    public void reduceStress(int amount) {
        stress = Math.max(0, stress - amount); // stress cannot go minus 
    }

   /**
     * Checks if the ranger is overstressed.
     * 
     * @return true if stress is high, false otherwise
     */
    public boolean isOverStressed() {
        return stress > 70;
    }
    
    
    /**
 * Performs emergency treatment using a vehicle.
 * @param a the injured animal
 * @param v the vehicle used
 * @param h the habitat
 */
public void emergencyTreat(Animal a, Vehicle v, Habitat h) { // special scene 
    System.out.println(name + " responding to emergency!");

    v.deployToHabitat(h);
    v.useEquipment();

    a.heal(40);
    a.stabilise();

    System.out.println(name + " stabilised " + a.getSpecies());
    System.out.println("Animal transported to rehabilitation zone");
}
}