package br.com.iesp.projeto.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class ServletLogin implements Filter {
	
	public void init(FilterConfig fConfig) {
	}
	
	public void doFilter (ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		String login = req.getParameter("user");
		String pass = req.getParameter("pwd");
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		if(SQLFilter.validation(login,pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			session.setMaxInactiveInterval(10*60);
			
			response.sendRedirect("menu.jsp");
		} else {
			chain.doFilter(req, resp);
		}
		
	}
	
	public void destroy() {
		
	}
}
