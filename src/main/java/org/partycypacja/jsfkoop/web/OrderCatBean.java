package org.partycypacja.jsfkoop.web;

import java.io.Serializable;

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
@Named("OrderCatBean")
public class OrderCatBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Produkt produkt = new Produkt();
	private Produkt prodDoZam = new Produkt(); 
	ListDataModel<Produkt> produkty = new ListDataModel<Produkt>();
	private Double ilosc;
	private long id; 
	
	@Inject
	private ProduktManager pm;
	@Inject
	private ZamowienieManager zm;
		
	private FacesContext fc = FacesContext.getCurrentInstance();
	private HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
	int tura = (Integer) session.getAttribute("Tura");
	private KoopMember mem = (KoopMember) session.getAttribute("user");
	private KoszykZamowien kz = (KoszykZamowien) session.getAttribute("koszyk"); 
	public int getTura() {
		return tura;
	}

	public void setTura(int tura) {
		this.tura = tura;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public KoszykZamowien getKz() {
		return kz;
	}

	public Double getIlosc() {
		return ilosc;
	}

	public void setIlosc(Double ilosc) {
		this.ilosc = ilosc;
	}
	
	public KoopMember getMem() {
		return mem;
	}

	public void setMem(KoopMember mem) {
		this.mem = mem;
	}
	public Produkt getProdukt() {
		return produkt;
	}
	
	public void setProdukt (Produkt produkt) {
		this.produkt=produkt;
	}
	
	public Produkt getProdDoZam() {
		return prodDoZam;
	}

	public void setProdDoZam(Produkt prodDoZam) {
		this.prodDoZam = prodDoZam;
	}

	public ListDataModel<Produkt> getCatProducts() {
		produkty.setWrappedData(pm.getCatProducts(id));
		return produkty;
	}
	
	public Produkt getProduktDet() {
		return pm.getOneProduct(prodDoZam);
	}
	
	public ListDataModel<Produkt> getDetails() {
		produkty.setWrappedData(pm.getOneProduct(prodDoZam));
		return produkty;
	}
	
	public String addProdukt() {
		pm.addProdukt(produkt);
		return null;
	}

	public String deleteProdukt() {
		Produkt produktToDelete = produkty.getRowData();
		pm.deleteProdukt(produktToDelete);
		return null;
	}

	
	public String getDetailedInfo() {
		prodDoZam = produkty.getRowData();
		return "zamow";
	}

	public String addOrder() {
		Zamowienie zamTemp = new Zamowienie (tura, mem.getId(), prodDoZam, ilosc);
//		zm.addZamowienie(zamTemp);
		kz.addZamowienie(zamTemp);
		return "ZamowAll";
	}
}
