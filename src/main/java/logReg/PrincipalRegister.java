package logReg;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import details.Principal;

@WebServlet("/register")
public class PrincipalRegister extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		int age = Integer.parseInt(req.getParameter("age"));
		long phno = Long.parseLong(req.getParameter("mobnum"));
		
		Principal p = new Principal();
		p.setName(name);
		p.setAge(age);
		p.setEmail(email);
		p.setPassword(pass);
		p.setPhno(phno);
		
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("schoolmanagement");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
		rd.forward(req, resp);
		
	}
	

}
