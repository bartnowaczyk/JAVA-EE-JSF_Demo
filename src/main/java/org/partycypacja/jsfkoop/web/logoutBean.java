package org.partycypacja.jsfkoop.web;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


@SessionScoped
@Named("outBean")
public class logoutBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public String logout () {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.removeAttribute("user");
		session.invalidate();
		return "index2.jsf?faces-redirect=true";
	}
}
