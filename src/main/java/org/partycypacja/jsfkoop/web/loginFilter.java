package org.partycypacja.jsfkoop.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.partycypacja.jsfkoop.domain.KoopMember;

public class loginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) arg0;
		HttpServletResponse httpRes = (HttpServletResponse) arg1; 
		HttpSession session = httpReq.getSession();
		String page = httpReq.getRequestURL().toString();
		KoopMember mem = (KoopMember) session.getAttribute("user");
		if (mem==null && !page.contains("index.jsf")) {
			httpRes.sendRedirect("index2.xhtml");
		}
		else {
			arg2.doFilter(arg0, arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
