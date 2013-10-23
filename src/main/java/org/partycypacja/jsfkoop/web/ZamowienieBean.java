package org.partycypacja.jsfkoop.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.partycypacja.jsfkoop.domain.Zamowienie;

@SessionScoped
@Named("zamBean")
public class ZamowienieBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Zamowienie zam = new Zamowienie();
	
	public Zamowienie getZam() {
		return zam;
	}
	public void setZam(Zamowienie zam) {
		this.zam = zam;
	}
	
	
	
}
