package org.partycypacja.jsfkoop.web;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.partycypacja.jsfkoop.domain.KoopMember;
import org.partycypacja.jsfkoop.domain.KoszykZamowien;
import org.partycypacja.jsfkoop.domain.Produkt;
import org.partycypacja.jsfkoop.domain.Zamowienie;
import org.partycypacja.jsfkoop.service.ProduktManager;
import org.partycypacja.jsfkoop.service.ZamowienieManager;

@SessionScoped
@Named("KoszykBean")
public class KoszykViewBean implements Serializable {
	private static final long serialVersionUID = 1L;
	ListDataModel<Zamowienie> zamowienia = new ListDataModel<Zamowienie>();

	private FacesContext fc = FacesContext.getCurrentInstance();
	private HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
	private KoszykZamowien kz = (KoszykZamowien) session.getAttribute("koszyk");
	private Zamowienie zamDoEdit;
	@Inject
	ZamowienieManager zm;
	
	public Zamowienie getZamDoEdit() {
		return zamDoEdit;
	}

	public void setZamDoEdit(Zamowienie zamDoEdit) {
		this.zamDoEdit = zamDoEdit;
	}

	public KoszykZamowien getKz() {
		return kz;
	} 

	public ListDataModel<Zamowienie> getallOrders() {
		zamowienia.setWrappedData(kz.getZakupy());
		return zamowienia;
	}
	
	public void Delete() {
		Zamowienie zamDoUsun = zamowienia.getRowData();
		kz.DeleteZamowienie(zamDoUsun);
	}
	
	public String Edit() {
		zamDoEdit = zamowienia.getRowData();	
		return "editOrder";
	}
	
	public String editOrder() {
		kz.EditZamowienie(zamDoEdit);
		return "Koszyk";		
	}

	public String Approve() {
		zm.ApproveOrder(kz);
		return "Koszyk";		
	}
	
}