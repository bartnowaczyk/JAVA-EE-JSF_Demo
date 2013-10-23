package org.partycypacja.jsfkoop.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.partycypacja.jsfkoop.domain.KoopMember;

@Stateless
public class KoopMemberManager {

	@PersistenceContext
	EntityManager em;
	
	private List<KoopMember> km = new ArrayList<KoopMember>();
	
	private KoopMember memb = new KoopMember();
	public void addKoopMember (KoopMember member) {
		em.persist(member);
	}
	
	public KoopMember getOneMember(int id) {
		KoopMember mem=em.find(KoopMember.class, id);
		return mem;
	}
	
	public int checkLogin (String login, String passwd) {
		int zwrot = 0;
		@SuppressWarnings("unchecked")
		List<KoopMember> temp = em.createNamedQuery("member.log").getResultList();
		for (KoopMember m: temp) {
			if (m.getPasswd().equals(passwd) && m.getLogin().equals(login)) {
				
				zwrot= m.getId();
				break;
			}

		}
		return zwrot;
	}
	
	@SuppressWarnings("unchecked")
	public List<KoopMember> getAllKoopMember() {
		List<KoopMember> kk;
		kk = em.createNamedQuery("member.all").getResultList();
		
		return kk;		
	}
 
	public void editMember (KoopMember mem) {
		em.createNamedQuery("member.upd").setParameter("login", mem.getLogin()).setParameter("nazwisko",mem.getNazwisko()).setParameter("mail", mem.getMail()).setParameter("telefon", mem.getTelefon()).setParameter("id", mem.getId()).executeUpdate();
	}

	public void changePass (KoopMember mem) {
		em.createNamedQuery("member.pass").setParameter("id", mem.getId()).setParameter("pass", mem.getPasswd()).executeUpdate();		
	}

	public KoopMember getMemb() {
		return memb;
	}

	public void setMemb(KoopMember memb) {
		this.memb = memb;
	}
	
	
}
