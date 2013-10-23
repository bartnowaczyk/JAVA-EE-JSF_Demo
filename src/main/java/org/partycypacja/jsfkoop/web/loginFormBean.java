package org.partycypacja.jsfkoop.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.partycypacja.jsfkoop.domain.KoopMember;
import org.partycypacja.jsfkoop.domain.KoszykZamowien;
import org.partycypacja.jsfkoop.service.KoopMemberManager;

@SessionScoped
@Named("logKoopBean")

public class loginFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private KoopMember member = new KoopMember();
	private String alert = "";
	
	@Inject
	KoopMemberManager km = new KoopMemberManager();
	
	public KoopMember getMember() {
		return member;
	}

	public void setMember(KoopMember member) {
		this.member = member;
	}
	
	public String addKoopMember () {
		km.addKoopMember(member);
		return null;
	}
	
	public String check() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		
		int co = km.checkLogin(member.getLogin(), member.getPasswd());

		if (co>0) {
			member = km.getOneMember(co);
			session.setAttribute("user",member);
			session.setAttribute("Tura", 35);
			KoszykZamowien kz = new KoszykZamowien();
			kz.setMember(member);
			kz.setOrderValue(0.00);
			session.setAttribute("koszyk", kz);
			return "ZamowAll";
		}
		else {
			alert = "Błędne hasło. Spróbuj jeszcze raz. ";
			return null;
		}
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}
	
}
