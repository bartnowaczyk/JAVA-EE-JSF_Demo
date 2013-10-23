package org.partycypacja.jsfkoop.web;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.partycypacja.jsfkoop.domain.KoopMember;

@ApplicationScoped
@Named("user")
public class userBean implements Serializable {

	private static final long serialVersionUID = 1L;
	FacesContext fc = FacesContext.getCurrentInstance();
	HttpSession http = (HttpSession) fc.getExternalContext().getSession(true);
	KoopMember member = (KoopMember) http.getAttribute("user");
	public KoopMember getMember() {
		return member;
	}
	public void setMember(KoopMember member) {
		this.member = member;
	}
	
	
	
}
