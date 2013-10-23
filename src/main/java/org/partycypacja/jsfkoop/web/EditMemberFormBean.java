package org.partycypacja.jsfkoop.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.partycypacja.jsfkoop.domain.KoopMember;
import org.partycypacja.jsfkoop.domain.KoszykZamowien;
import org.partycypacja.jsfkoop.domain.Zamowienie;
import org.partycypacja.jsfkoop.service.KoopMemberManager;

@SessionScoped
@Named("editMemberBean") 
public class EditMemberFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesContext fc = FacesContext.getCurrentInstance();
	private HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
	private KoopMember editMember = (KoopMember) session.getAttribute("user");
	private KoopMember doZmiany = new KoopMember();
	
	@Inject	
	KoopMemberManager km;
	
	
	public KoopMember getEditMember() {
		return editMember;
	}
	public void setEditMember(KoopMember editMember) {
		this.editMember = editMember;
	}
	
	public KoopMember getDoZmiany() {
		return doZmiany;
	}
	public void setDoZmiany(KoopMember doZmiany) {
		this.doZmiany = doZmiany;
	}
	public String change(){
		km.editMember(editMember);
		return null;
	}
	
	
	
}
