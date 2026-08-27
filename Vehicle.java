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
 * Represents a vehicle used by rangers.
 */
public class Vehicle {

    private final String id;
    private int fuelLevel;
   // private int capacity;
    private final String equipment;

    public Vehicle(String id, int fuelLevel,String equipment) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        //this.capacity = capacity;
        this.equipment = equipment;
    }

    /**
     * Refuels the vehicle.
     */
    public void refuel() {
        fuelLevel = 100;
    }
    public int getFuelLevel() { 
        return fuelLevel;
    }
    
    /**
 * Deploys the vehicle to a habitat.
 * Consumes fuel during travel.
 *
 * @param h the habitat to deploy to
 */
public void deployToHabitat(Habitat h) {
    if (fuelLevel > 0) {
        System.out.println("Vehicle " + id + " deployed to habitat " + h.getName());
        fuelLevel -= 20;
    } else {
        System.out.println("Vehicle " + id + " has no fuel!");
    }
}

/**
 * Uses the vehicle's equipment in an emergency.
 */
public void useEquipment() {
    System.out.println("Using equipment: " + equipment);
}

/**
 * Checks if the vehicle has fuel.
 *
 * @return true if fuel is available
 */
public boolean hasFuel() {
    return fuelLevel > 0;
}

/**
 * Consumes fuel.
 *
 * @param amount fuel to consume
 */
public void consumeFuel(int amount) {
    fuelLevel = Math.max(0, fuelLevel - amount);
}

/**
 * Transports a ranger to a habitat.
 * @param r the ranger
 * @param h the habitat
 */
public void transportRanger(Ranger r, Habitat h) {
    if (fuelLevel > 0) {
       System.out.println("Vehicle " + id + " transported ranger to " + h.getName());
        consumeFuel(20);
    }
}
    
    
    
    
    
}
