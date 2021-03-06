package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.Article;
import beans.Categorie;
import beans.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/articles")
public class ArticleServlet extends HttpServlet {

	private List<beans.Article> articles = new ArrayList<beans.Article>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("utilisateurs") != null && session.getAttribute("categories") != null) {
			req.setAttribute("auteurs", session.getAttribute("utilisateurs"));
			req.setAttribute("categories", session.getAttribute("categories"));
			req.setAttribute("articles", articles);
			this.getServletContext().getRequestDispatcher("/WEB-INF/article/create_article.jsp").forward(req, resp);
		} else if (null == session.getAttribute("utilisateurs")) {
			resp.sendRedirect("/ECommerceFliter/utilisateurs");
		} else {
			resp.sendRedirect("/ECommerceFliter/categories");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
		String contenu = req.getParameter("contenu");
		String auteur = req.getParameter("auteur");
		String categorie = req.getParameter("categorie");
		String message;
		HttpSession session = req.getSession();
		List<beans.Utilisateur> auteurs = (List<Utilisateur>) session.getAttribute("utilisateurs");
		List<beans.Categorie> categories = (List<Categorie>) session.getAttribute("categories");

		if (titre.trim().isEmpty() || description.trim().isEmpty() || contenu.trim().isEmpty()
				|| auteur.trim().isEmpty()) {
			message = "Merci de remplir tout les champs !";
			req.setAttribute("message", message);
		} else {
			beans.Article article = new Article();
			article.setTitre(titre);
			article.setContenu(contenu);
			article.setDescription(description);
			categories.forEach(c->{
				if(c.getTitre().equals(categorie)) {
					article.setCategorie(c);
				}
			});
			auteurs.forEach(a -> {
				if (a.getEmail().equals(auteur)) {
					article.setAuteur(a);
				}
			});
			articles.add(article);
		}
		req.setAttribute("auteurs", auteurs);
		req.setAttribute("categories", categories);
		req.setAttribute("articles", articles);
		this.getServletContext().getRequestDispatcher("/WEB-INF/article/create_article.jsp").forward(req, resp);

	}

}
