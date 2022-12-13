package champollion;

import java.util.*;

public class UE {

    private final String intitule;
    private int heureCM;
    private int heureTP;
    private int heureTD;
    private HashMap<Enseignant, ServicePrevu> lesIntervenants;
    private ArrayList<Intervention> lesSeances;

    public UE(String intitule, int heureCM, int heureTP, int heureTD) {
        this.intitule = intitule;
        this.heureCM = heureCM;
        this.heureTP = heureTP;
        this.heureTD = heureTD;
        this.lesIntervenants = new HashMap<Enseignant, ServicePrevu>();
        this.lesSeances = new ArrayList<Intervention>();
    }


    public String getIntitule() {
        return intitule;
    }

    public int getHeureCM(){
        return this.heureCM;
    }

    public int getHeureTP(){
        return this.heureTP;
    }

    public int getHeureTD(){
        return this.heureTD;
    }
    public void addIntervenant(Enseignant e, ServicePrevu s){
        this.lesIntervenants.put(e, s);
    }

    public ServicePrevu getService(Enseignant e){
        return this.lesIntervenants.get(e);
    }

    public boolean checkVolumeHoraire(ServicePrevu s){
        if(s.getVolumeCM() > this.heureCM || s.getVolumeTD() > this.heureTD || s.getVolumeTP() > this.heureTP){
            return false;
        }
        else{
            return true;
        }
    }

    public void addService(Enseignant e, ServicePrevu s1){
        ServicePrevu sp2 = this.lesIntervenants.get(e);
        sp2.ajouterHeures(s1);
        this.lesIntervenants.put(e, sp2);
    }
    public int getNbIntervention(){
        return this.lesSeances.size();
    }
    public void addSeance(Intervention i){
        this.lesSeances.add(i);
    }   
}
