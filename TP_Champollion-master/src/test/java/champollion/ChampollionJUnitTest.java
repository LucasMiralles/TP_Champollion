package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java,genielog;
	Intervention cours1, cours2, cours3, cours4;
	Salle s1, s2;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML", 25, 18, 12);
		java = new UE("Programmation en java",22, 15, 11);
		s1 = new Salle("105", 20);
		s2 = new Salle("101", 20);

		cours1 = new Intervention(new Date(), 2, 10, java, TypeIntervention.TD, s2);
		genielog = new UE("Genie log", 70, 65, 52);
		cours2 = new Intervention(new Date(), 3, 10, genielog, TypeIntervention.CM, s1);
		cours3 = new Intervention(new Date(), 2, 10, genielog, TypeIntervention.TP, s1);
		cours4 = new Intervention(new Date(), 6, 10, genielog, TypeIntervention.TD, s2);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() throws Exception{
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

     /*          // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'"); */
		
	}
	@Test
	public void testAjouterInterventions(){
		untel.ajouteIntervention(cours1);

		assertEquals(1, java.getNbIntervention());
		assertEquals(1, untel.getNbIntervention());
	}

	@Test
	public void testEnSousService() throws Exception{
		assertEquals(true, untel.enSousService());
	}
}
