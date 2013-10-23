package org.partycypacja.jsfkoop.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.partycypacja.jsfkoop.domain.KoopMember;
import org.partycypacja.jsfkoop.domain.KoszykZamowien;
import org.partycypacja.jsfkoop.domain.Zamowienie;

@Stateless
public class ZamowienieManager {

	@PersistenceContext
	private EntityManager em;
	
	public void addZamowienie (Zamowienie zam){
		em.persist(zam);
	}
	
	public void deleteZamowiemnie (Zamowienie zam) {
		zam = em.find(Zamowienie.class, zam.getId());
		em.remove(zam);
	}
	
	@SuppressWarnings("unchecked")
	public List<Zamowienie> getAllZamowienie() {
		 return em.createNamedQuery("Zamowienie.all").getResultList();
	}
	
	public void ApproveOrder (KoszykZamowien kz) {
		List<Zamowienie> temp = kz.getZakupy();
		for (Zamowienie z: temp) {
			if (z!=null) 
				addZamowienie(z);
		}
		kz.setOrderValue(0.00);
		kz.getZakupy().clear();
	}
}
