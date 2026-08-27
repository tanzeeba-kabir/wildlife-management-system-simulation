/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserve11;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kabir
 */

/**
 * Represents a habitat containing animals.
 */
public class Habitat {

    private final String name;
    private final int capacity;
    private final List<Animal> animals;
    private boolean unsafe = false; // intially is the habitat is safe 
    /**
     * Creates a habitat.
     * 
     * @param name the name of the habitat
     * @param capacity the maximum number of animals
     */
    public Habitat(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        animals = new ArrayList<>();
    }
    /**
     * Adds an animal to the habitat.
     * 
     * @param a the animal to add
     */
    public void addAnimal(Animal a) {
        if (animals.size() < capacity) {
            animals.add(a);
            System.out.println(a.getSpecies() + " entered habitat " + name);
        }
        else {
            System.out.println("Habitat is full!");
        }
    }
    /**
     * Removes an animal from the habitat.
     * 
     * @param a the animal to remove
     */
    public void removeAnimal(Animal a) {
        animals.remove(a);
        System.out.println(a.getSpecies() + " left habitat " + name);
    }

    /**
     * Stress all animals due to poacher.
     */
    public void poacherAttack() {
        for (Animal a : animals) {
            a.injure(10);
        }
         setUnsafe(true);
    }
    
    /**
     * Sets habitat safety.
     * 
     * @param value true if unsafe
     */
    public void setUnsafe(boolean value) {
        unsafe = value;
        if (unsafe) {
            System.out.println("Habitat " + name + " is now UNSAFE!");
        }
    }
    
     /**
     * Checks if habitat is unsafe.
     * 
     * @return true if unsafe
     */
    public boolean isUnsafe() {
        return unsafe;
    }
    
     /**
     * Returns all animals.
     * 
     * @return list of animals
     */
    public List<Animal> getAnimals() {
        return animals;
    }
 /**
     * Returns habitat name.
     * 
     * @return habitat name
     */
    public String getName() {
        return name;
    }

  
}

