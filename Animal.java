/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserve11;

/**
 *
 * @author kabir
 */
public class Animal {
 

/**
 * Represents an animal in the reserve.
 * Stores health, stress and behavior state.
 */
    private final String species;// final used when a value should not change after initialization
    private int health;
    private int stressLevel;
    private final Temperament temperament;
    private State state;
// Array = list of values
//Enum = fixed set of named values
    
    // Temperament and State have fixed possible values thats why enums 
    public enum Temperament {
        PASSIVE, DEFENSIVE, CURIOUS, AGGRESSIVE
    }

    public enum State {
        CALM, ALERTED, FLEEING, ATTACKING, STABILISED, CRITICAL
    }

    public Animal(String species, int health, int stressLevel, Temperament temperament) {
        this.species = species;
        this.health = health;
        this.stressLevel = stressLevel;
        this.temperament = temperament;
        this.state = State.CALM; // normal state of the animal is usually calm
    }
/**
 * Reduces health and increases stress of the animal.
 * Updates its state accordingly.
 * @param damage amount of damage taken
 */
    
    
    public void injure(int damage) {
    health = Math.max(0, health - damage); // if number is negative it sets health to zero
    stressLevel = Math.min(100, stressLevel + 20);// stress level cannot be too high breaks the scale
    updateState(); // after getting injured the animal's state must be recalculated 
    
    }
    // sets it to critical if the codition is too bad 
    public boolean isCritical() {
    return state == State.CRITICAL;
    }

/**
 * Heals the animal and reduces stress.
 * Updates its state accordingly.
 * @param amount amount of healing
 */
    public void heal(int amount) {
        health =  Math.min(100, health + amount) ;// health level cannot be too high 
        stressLevel = Math.max(0, stressLevel - 20);// stress level cannot go below 0 
        updateState(); // After healing the animal’s state must be recalculated
    }
    
    public void increaseStress(int amount) {
    stressLevel = Math.min(100, stressLevel + amount);
    updateState();
}
    
    
    public void calmDown() {
    stressLevel = 0;
    updateState();
}
    public void decreaseStress(int amount) {
    stressLevel = Math.max(0, stressLevel - amount);
    updateState();
}

    
    public void flee() {
    state = State.FLEEING;
}

public void attack() {
    state = State.ATTACKING;
} 

    /**
     * Updates state based on health and stress.
     */
    private void updateState() {
     if (health < 30) {
        state = State.CRITICAL;
    } 
    else if (health > 80 && stressLevel < 20) {
        state = State.STABILISED;
    } 
    else if (stressLevel > 80) {
        state = State.FLEEING;
    } 
    else if (stressLevel > 50) {
        state = State.ALERTED;
    } 
    else {
        state = State.CALM;
    }
    }

    public String getSpecies() { 
        return species;
    }
    public State getState() { 
        return state;
    }
    
    /**
 * Determines how the animal reacts when a ranger approaches.
 * Aggressive animals will attack and change their state to ATTACKING.
 *
 * @return true if the animal attacks the ranger, false otherwise
 */
 
public boolean reactToRanger() {
    switch (temperament) {
        case AGGRESSIVE:
            state = State.ATTACKING;
            return true;

        case DEFENSIVE:
            state = State.ALERTED;
            break;

        case CURIOUS:
            state = State.ALERTED;
            break;

        case PASSIVE:
            state = State.CALM;
            break;
    }
    return false;
}
 
public void stabilise() {
    state = State.STABILISED;
    stressLevel = 0;
    System.out.println(species + " is stabilised."); // when stabilised the stress is auto 0
} 
    
}

