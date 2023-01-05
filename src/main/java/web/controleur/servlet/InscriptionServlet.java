package web.controleur.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.dao.IInscription;
import metier.dao.IUser;
import metier.dao.InscriptionMetierImpl;
import metier.dao.UserMetierImpl;
import metier.entities.Inscription;
import metier.entities.User;
import web.model.InscriptionModel;

@WebServlet(name = "is", urlPatterns = { "/lister.is", "*.is" })
public class InscriptionServlet extends HttpServlet {

	IInscription iinscription = null;
	InscriptionModel imodel;
	IUser iu = null;

	@Override
	public void init() throws ServletException {
		iinscription = new InscriptionMetierImpl();
		iu = new UserMetierImpl();
		imodel = new InscriptionModel();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getServletPath().equals("/lister.is")) {
			List<Inscription> inscriptions = iinscription.findAll();
			imodel.setInscriptions(inscriptions);
			req.setAttribute("inscriptions", imodel);
			req.getRequestDispatcher("/WEB-INF/vue/inscription/findAll.jsp").forward(req, resp);
		} else if (req.getServletPath().equals("/ajouter.is")) {
			req.getRequestDispatcher("/WEB-INF/vue/inscription/add.jsp").forward(req, resp);
		} else if (req.getServletPath().equals("/update.is")) {
			int id = Integer.parseInt(req.getParameter("id"));
			imodel.setId(id);
			Inscription inscription = iinscription.findById(id);
			imodel.setId(inscription.getId());
			imodel.setClasse(inscription.getClasse());
			imodel.setDate(inscription.getDate());
			imodel.setUser(inscription.getUser());
			req.setAttribute("inscription", imodel);
			req.getRequestDispatcher("/WEB-INF/vue/inscription/update.jsp").forward(req, resp);
		} else if (req.getServletPath().equals("/delete.is")) {
			int id = Integer.parseInt(req.getParameter("id"));
			imodel.setId(id);
			iinscription.delete(id);
			List<Inscription> inscriptions = iinscription.findAll();
			imodel.setInscriptions(inscriptions);
			req.setAttribute("inscriptions", imodel);
			// req.getRequestDispatcher("/WEB-INF/vue/inscription/findAll.jsp").forward(req,
			// resp);
			resp.sendRedirect(req.getContextPath() + "/lister.is");
		} else if (req.getServletPath().equals("/ajout.is") && req.getMethod().toLowerCase().equals("post")) {
			String str = req.getParameter("date");
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String classe = req.getParameter("classe");
			int idUser = Integer.parseInt(req.getParameter("iduser"));
			imodel.setClasse(classe);
			imodel.setDate(date);
			Inscription inscription = new Inscription(date, classe);
			iinscription.add(inscription, idUser);
			List<Inscription> inscriptions = iinscription.findAll();
			imodel.setInscriptions(inscriptions);
			req.setAttribute("inscriptions", imodel);
			// req.getRequestDispatcher("/WEB-INF/vue/inscription/findAll.jsp").forward(req,
			// resp);
			resp.sendRedirect(req.getContextPath() + "/lister.is");
		} else if (req.getServletPath().equals("/modif.is") && req.getMethod().toLowerCase().equals("post")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String str = req.getParameter("date");
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String classe = req.getParameter("classe");
			int idUser = Integer.parseInt(req.getParameter("iduser"));
			imodel.setId(id);
			imodel.setClasse(classe);
			imodel.setDate(date);
			Inscription inscription = new Inscription();
			inscription.setDate(date);
			inscription.setClasse(classe);
			User user = iu.findById(idUser);
			imodel.setUser(user);
			inscription.setUser(user);
			inscription.setId(id);
			iinscription.update(inscription);
			List<Inscription> inscriptions = iinscription.findAll();
			imodel.setInscriptions(inscriptions);
			req.setAttribute("inscriptions", imodel);
			// req.getRequestDispatcher("/WEB-INF/vue/inscription/findAll.jsp").forward(req,
			// resp);
			resp.sendRedirect(req.getContextPath() + "/lister.is");
		} else {
			resp.sendError(resp.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
