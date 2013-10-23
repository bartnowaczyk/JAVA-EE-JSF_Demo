package org.partycypacja.jsfkoop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "products.all", query = "Select p from Produkt p"),
	@NamedQuery(name = "products.cat", query = "Select p from Produkt p where p.kategoria.id = :choosencategory")
})
public class Produkt {
	private long id; 
	private String nazwa;
	private String jednostka;
	private Kategoria kategoria;
	private Double ostatniaCena;
	private Double naszaCena;
	private Double sklepowaCena;
	private String kategoriaNazwa;
	private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>(); 	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNazwa() {
		return nazwa;
	}


	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}


	public String getJednostka() {
		return jednostka;
	}


	public void setJednostka(String jednostka) {
		this.jednostka = jednostka;
	}

	@JoinColumn(name="kategoria")

	@ManyToOne(fetch = FetchType.EAGER)
	public Kategoria getKategoria() {
		return kategoria;
	}	

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public Double getOstatniaCena() {
		return ostatniaCena;
	}

	public void setOstatniaCena(Double ostatniaCena) {
		this.ostatniaCena = ostatniaCena;
	}


	public Double getNaszaCena() {
		return naszaCena;
	}


	public void setNaszaCena(Double naszaCena) {
		this.naszaCena = naszaCena;
	}


	public Double getSklepowaCena() {
		return sklepowaCena;
	}


	public void setSklepowaCena(Double sklepowaCena) {
		this.sklepowaCena = sklepowaCena;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Zamowienie> getZamowienia() {
			return zamowienia;
	}


	public void setZamowienia(List<Zamowienie> zamowienia) {
		this.zamowienia = zamowienia;
	}
	
	

	/*
	public void setListZamowienie(List<Zamowienie> listZamowienie) {
		this.listZamowienie = listZamowienie;
	}
	*/
}

