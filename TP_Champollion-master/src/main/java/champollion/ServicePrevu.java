package champollion;

public class ServicePrevu {
    // TODO : implémenter cette classe

    private int volumeCM;
    private int volumeTD;
    private int volumeTP;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }
    public long getEquivalentTD(){
        //Math.round pour arrondir au multiple supérieur le plus proche
		return Math.round(this.volumeCM*1.5 + this.volumeTD + this.volumeTP*0.75);
	}

	public int getVolumeCM(){
		return volumeCM;
	}

	public int getVolumeTD(){
		return volumeTD;
	}

	public int getVolumeTP(){
		return volumeTP;
	}
        
	public void ajouterHeures(ServicePrevu s){
		this.volumeCM += s.getVolumeCM();
		this.volumeTD += s.getVolumeTD();
		this.volumeTP += s.getVolumeTP();
	}
}
