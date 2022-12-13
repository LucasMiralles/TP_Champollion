package champollion;

import java.util.*;

public class Enseignant extends Personne {

    private ArrayList<UE> lesEnseignements;
    private ArrayList<Intervention> lesInterventions;

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.lesEnseignements = new ArrayList<UE>();
        this.lesInterventions = new ArrayList<Intervention>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures
     * équivalent TD" Pour le calcul : 1 heure de cours magistral vaut 1,5 h
     * "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut
     * 0,75h "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        long h = 0;
        for (int i = 0; i < this.lesEnseignements.size(); i++) {
            h += this.lesEnseignements.get(i).getService(this).getEquivalentTD();
        }
        return (int) h;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE
     * spécifiée en "heures équivalent TD" Pour le calcul : 1 heure de cours
     * magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent
     * TD" 1 heure de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        ServicePrevu s = ue.getService(this);
        long h = s.getEquivalentTD();
        return (int) h;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     * @throws Exception
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) throws Exception {
        ServicePrevu s = new ServicePrevu(volumeCM, volumeTD, volumeTP);
        if (!(ue.checkVolumeHoraire(s))) {
            throw new Exception("Le volume horaire ne correspond pas");
        }
        if (!(this.lesEnseignements.contains(ue))) {
            this.lesEnseignements.add(ue);
            ue.addIntervenant(this, s);
        } else {
            ue.addService(this, s);
        }
    }
    public int getNbIntervention(){
        return this.lesInterventions.size();
    }

    public void ajouteIntervention(Intervention i) {
        this.lesInterventions.add(i);
        UE ue = i.getMatiere();
        System.out.println(i.getMatiere());
        ue.addSeance(i);
    }

    public boolean enSousService() {
        return this.heuresPrevues() < 192;
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        ServicePrevu s = ue.getService(this);
        int nbHeurePlanif = 0;
        for (int i = 0; i < this.lesInterventions.size(); i++) {
            if (this.lesInterventions.get(i).getType() == type) {
                nbHeurePlanif += this.lesInterventions.get(i).getDuree();
            }
        }

        return Math.round(s.getEquivalentTD() - nbHeurePlanif);
    }
}
