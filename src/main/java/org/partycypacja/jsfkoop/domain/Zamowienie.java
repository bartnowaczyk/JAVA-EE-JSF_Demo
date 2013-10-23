package org.partycypacja.jsfkoop.domain;


import java.util.Map;

import javax.enterprise.inject.Typed;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.joda.time.DateTime;
import org.joda.time.contrib.hibernate.PersistentLocalDate;

@Entity
@NamedQueries({
	@NamedQuery(name="Zamowienie.all", query="Select z from Zamowienie z")
})

public class Zamowienie {
	private long id;
	private int tura;
//	private KoopMember koopmember;
//	private Produkt produkt;
	private Double ilosc;
	private int koopmember;
	private Produkt produkt;
	
	
	
	public Zamowienie(int tura,  int koopmember, Produkt produkt, Double ilosc) {
		
		this.tura = tura;
		this.koopmember = koopmember;
		this.produkt = produkt;
		this.ilosc = ilosc;
	}

	public Zamowienie () {
		
	}
	
	public int getKoopmember() {
		return koopmember;
	}

	public void setKoopmember(int koopmember) {
		this.koopmember = koopmember;
	}

	@JoinColumn(name="produkt")

	@ManyToOne(fetch = FetchType.EAGER)
	public Produkt getProdukt() {
		return produkt;
	}	

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Double getIlosc() {
		return ilosc;
	}

	public void setIlosc(Double ilosc) {
		this.ilosc = ilosc;
	}
	
	public int getTura() {
		return tura;
	}

	public void setTura(int tura) {
		this.tura = tura;
	}
	
/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="produkt")
	public Produkt getProdukt() {
		return produkt;
	}
	
	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	@ManyToOne
	@JoinColumn(name="produkt")
	public KoopMember getMember() {
		return koopmember;
	}

	public void setMember(KoopMember koopmember) {
		this.koopmember = koopmember;
	}
	*/
}
