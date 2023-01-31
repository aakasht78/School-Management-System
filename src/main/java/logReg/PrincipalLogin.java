package logReg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import details.Principal;

@WebServlet("/login")
public class PrincipalLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("schoolmanagement");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
	
		

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		
		Query q = em.createQuery("select a from Principal a where a.email=?1 and password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<Principal>p=q.getResultList();
		if(p.size()>0) {
			RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
			rd.forward(req, resp);
		}
		else {
			pw.println("Invalid.... Try again");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		
	}
}
