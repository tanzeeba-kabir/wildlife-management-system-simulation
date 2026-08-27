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
 * Represents a poacher targeting animals.
 */
public class Poacher {

    private final String name;
    private final String targetSpecies;
    private final int dangerLevel;

    public Poacher(String name, String targetSpecies, int dangerLevel) {
        this.name = name;
        this.targetSpecies = targetSpecies;
        this.dangerLevel = dangerLevel;
    }

    public int getDangerLevel() { 
        return dangerLevel; 
    }
    public String getName() {
        return name; 
    }
     /**
 * Initiates an attack on a habitat.
 * This causes stress to all animals in the habitat.
 *
 * @param h the habitat being attacked
 */
    public void attackHabitat(Habitat h) {
        System.out.println(name + " is attacking habitat " + h.getName());
        h.poacherAttack();
    }
    /**
 * Selects an animal from the habitat that matches the poacher's target species.
 *
 * @param h the habitat to search for target animals
 * @return the targeted animal if found, otherwise null
 */
    
    
    
      public Animal chooseTarget(Habitat h) {
        for (Animal a : h.getAnimals()) {
            if (a.getSpecies().equals(targetSpecies)) {
                return a; // choosing a target animal for poacher in a habitat
            }
        }
        return null;
    }
      /**
 * Attacks a specific animal, causing damage.
 *
 * @param a the animal to attack
 */
      
       public void attackAnimal(Animal a) {
        if (a != null) {
            System.out.println(name + " attacked " + a.getSpecies());
            a.injure(20); // sets animal injure to 20
        }
    }
    
    
}

