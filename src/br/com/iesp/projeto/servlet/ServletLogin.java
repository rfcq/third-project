package br.com.iesp.projeto.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.iesp.projeto.filter.doFilter;


@WebServlet("/checker")
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String login = req.getParameter("user");
		String pass = req.getParameter("pwd");
		
		if(doFilter.validation(login,pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
			session.setMaxInactiveInterval(10*60);
			
			resp.sendRedirect("menu.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/checker.jsp");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red>Wrong username or password!</font>");
			rd.include(req, resp);
		}
		
	}
}
