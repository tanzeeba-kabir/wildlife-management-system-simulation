/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserve11;

/**
 *
 * @author kabir
 */



import java.util.ArrayList;
import java.util.List;

/**
 * Represents the whole wildlife reserve.
 */
public class Reserve {

    private final List<Habitat> habitats;
    private final List<Ranger> rangers;
    private final List<Poacher> poachers;

    public Reserve() {
        habitats = new ArrayList<>();
        rangers = new ArrayList<>();
        poachers = new ArrayList<>();
    }

    public void addHabitat(Habitat h) {
        habitats.add(h);
    }

    public void addRanger(Ranger r) {
        rangers.add(r);
    }

    public void addPoacher(Poacher p) {
        poachers.add(p);
    }

    /**
     * Simulates one day in the reserve.
     */
    public void simulateDay() {
        System.out.println("Simulation running...");

        // Rangers patrol habitats
        for (Ranger r : rangers) {
            for (Habitat h : habitats) {
                r.patrol(h);
            }
        }

        // Poachers attack habitats
        for (Poacher p : poachers) {
            for (Habitat h : habitats) {
                p.attackHabitat(h);
            }
        }

        // Report
        reportStatus();

        System.out.println("Day ended.");
    }

    /**
     * Reports the state of the reserve.
     */
    public void reportStatus() {
        System.out.println("Reserve status report:");

        for (Habitat h : habitats) {
            System.out.println("Habitat: " + h.getName());
            for (Animal a : h.getAnimals()) {
                System.out.println(" - " + a.getSpecies() + " (" + a.getState() + ")");
            }
        }
    }
}