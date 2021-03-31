package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(Integer periodo){
		return corsoDao.getIscrittiByPeriodo(periodo);
	}
	
	public List<Studente> getStudentiByCorso(String codice){
		return corsoDao.getStudentiByCorso(new Corso(codice, null, null, null));
	}

	public boolean esisteCorso(String codice) {
		return corsoDao.esisteCorso(new Corso(codice, null, null, null));
	}
	
	public Map<String, Integer> getDivisioneCDS(String codice) {
		//ci possono essere gestionali, informatici, meccanici, ...
				
		//SOLUZIONE 1
		/* Map<String, Integer> divisione = new HashMap<>();
		   List<Studente> studenti = this.getStudentiByCorso(codice);
		 * 
		 * for(Studente s: studenti) {
			if(s.getCDS() != null && !s.getCDS().equals("")) {
			if(divisione.get(s.getCDS()) == null)
			{
				divisione.put(s.getCDS(), 1);
			}else {
				divisione.put(s.getCDS(), divisione.get(s.getCDS()) +1);
			}}
		}*/
		
		//SOLUZIONE 2
		return corsoDao.getDivisioneStudenti(new Corso(codice, null, null, null));
	}
}
