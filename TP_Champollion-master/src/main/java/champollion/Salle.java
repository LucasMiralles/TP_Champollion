/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.*;

/**
 *
 * @author Utilisateur
 */
public class Salle {

    private final String intitule;
    private final int capacite;

    private Set<Intervention> lesSalles = new HashSet<>();

    public Salle(String intitule, int capacite) {
        this.intitule = intitule;
        this.capacite = capacite;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void addOccupation(Intervention intervention) {
        lesSalles.add(intervention);
    }
}
