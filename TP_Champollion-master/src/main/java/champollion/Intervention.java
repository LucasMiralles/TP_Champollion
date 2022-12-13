/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Date;

/**
 *
 * @author Utilisateur
 */
public class Intervention {

    private Date debut;
    private int duree;
    private boolean annulee = false;
    private int heureDeb;
    private UE matiere;
    private TypeIntervention type;
    private Salle salle;

    public Intervention(Date debut, int duree, int heureDeb, UE matiere, TypeIntervention type, Salle salle) {
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDeb = heureDeb;
        this.matiere = matiere;
        this.type = type;
        this.salle = salle;
    }

    public UE getMatiere() {
        return this.matiere;
    }

    public TypeIntervention getType() {
        return this.type;
    }

    public int getDuree() {
        return this.duree;
    }

    public Salle getSalle() {
        return salle;
    }

}
