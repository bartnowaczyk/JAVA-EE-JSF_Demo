package org.partycypacja.jsfkoop.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.partycypacja.jsfkoop.service.ZamowienieManager;

public class KoszykZamowien  {
	private KoopMember member;
	private List<Zamowienie> zakupy;
	private Double OrderValue;

	
	@Inject
	private ZamowienieManager zm;
	
	public KoszykZamowien () {
		zakupy = new ArrayList<Zamowienie>();
		member = new KoopMember();
		OrderValue = 0.00;
	}


	public Double getOrderValue() {
		return OrderValue;
	}


	public void setOrderValue(Double orderValue) {
		OrderValue = orderValue;
	}


	public void addValue(Double price, Double quantity) {
		OrderValue += price*quantity;
	}

	public void subsValue(Double price, Double quantity) {
		OrderValue -= price*quantity;
	}
	
	public KoopMember getMember() {
		return member;
	}
	
	public void setMember(KoopMember member) {
		this.member = member;
	}
	
	public List<Zamowienie> getZakupy() {
		return zakupy;
	}
	public void setZakupy(List<Zamowienie> zakupy) {
		this.zakupy = zakupy;
	}
	
	public void addZamowienie(Zamowienie zam) {
		zakupy.add(zam);
		addValue(zam.getProdukt().getOstatniaCena(), zam.getIlosc());
	}

	public void DeleteZamowienie(Zamowienie zam) {
		subsValue(zam.getProdukt().getOstatniaCena(),zam.getIlosc());
		zakupy.remove(zam);
	}
	
	public void setCurrentValue() {
		this.OrderValue = 0.00;
		for (Zamowienie z : zakupy) {
			this.OrderValue = z.getProdukt().getOstatniaCena()*z.getIlosc();
		}
		
	}
	
	public void EditZamowienie(Zamowienie zam) {
		for (int i=0; i<zakupy.size(); i++) {
			if (zakupy.get(i).equals(zam)) {
				zakupy.set(i, zam);
				setCurrentValue();
			}
		}
	}
	public void ApproveOrder () {
		for (Zamowienie z: zakupy) {
			if (z!=null) 
				zm.addZamowienie(z);
		}
		setOrderValue(0.00);
		zakupy.clear();
	}

	
}
