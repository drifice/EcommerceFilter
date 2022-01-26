package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.Categorie;
import beans.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/categories")
public class CategorieServlet extends HttpServlet {
	
	private List<Categorie> categories = new ArrayList<Categorie>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categories", this.categories);
		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/create_categorie.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String titre = req.getParameter("titre");
			String message;
	
			if (titre.trim().isEmpty() ) {
				message = "Merci de remplir tout les champs";
				req.setAttribute("message", message);
			} else {
				Categorie categorie = new Categorie();
				categorie.setTitre(titre);
				this.categories.add(categorie);
			}
			req.setAttribute("categories", this.categories);
			HttpSession session = req.getSession();
			session.setAttribute("categories", categories);
			this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/create_categorie.jsp").forward(req, resp);
	}

}
