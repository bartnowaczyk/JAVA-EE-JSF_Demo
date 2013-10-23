package org.partycypacja.jsfkoop.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.partycypacja.jsfkoop.domain.Produkt;

@Stateless
public class ProduktManager {
	
	@PersistenceContext
	EntityManager em;
		
	public void addProdukt(Produkt produkt) {
		em.persist(produkt);
	}
	
	public void deleteProdukt (Produkt produkt) {
		produkt = em.find(Produkt.class, produkt.getId());
		em.remove(produkt);
	}
	
	public Produkt getOneProduct (Produkt produkt) {
		return em.find(Produkt.class, produkt.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Produkt> getAllProducts() {
		return em.createNamedQuery("products.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produkt> getCatProducts(long cat) {
		List<Produkt> temp = new ArrayList<Produkt>();
		temp = em.createNamedQuery("products.cat").setParameter("choosencategory", cat).getResultList();
		return temp;
	}

}
