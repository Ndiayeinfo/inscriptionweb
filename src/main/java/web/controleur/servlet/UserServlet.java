package web.controleur.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.dao.IUser;
import metier.dao.UserMetierImpl;
import metier.entities.User;
import web.model.UserModel;

public class UserServlet extends HttpServlet {

	IUser iu = null;
	List<User> users = null;
	UserModel umodel = null;

	@Override
	public void init() throws ServletException {
		iu = new UserMetierImpl();
		umodel = new UserModel();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getServletPath().equals("/lister.us")) {
			users = iu.findAll();
			umodel.setUsers(users);
			req.setAttribute("users", umodel);
			req.getRequestDispatcher("/WEB-INF/vue/user/findAll.jsp").forward(req, resp);
		} else if (req.getServletPath().equals("/ajouter.us")) {
			req.getRequestDispatcher("/WEB-INF/vue/user/add.jsp").forward(req, resp);
		} else if (req.getServletPath().equals("/update.us")) {
			int id = Integer.parseInt(req.getParameter("id"));
			umodel.setId(id);
			User user = iu.findById(id);
			umodel.setEmail(user.getEmail());
			umodel.setPassword(user.getPassword());
			req.setAttribute("user", umodel);
			req.getRequestDispatcher("/WEB-INF/vue/user/update.jsp").forward(req, resp);
		} else if (req.getServletPath().equals("/delete.us")) {
			int id = Integer.parseInt(req.getParameter("id"));
			umodel.setId(id);
			iu.delete(id);
			users = iu.findAll();
			umodel.setUsers(users);
			req.setAttribute("users", umodel);
			// req.getRequestDispatcher("/WEB-INF/vue/user/findAll.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/lister.us");
		} else if (req.getServletPath().equals("/ajout.us") && req.getMethod().toLowerCase().equals("post")) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			umodel.setEmail(email);
			umodel.setPassword(password);
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			iu.add(user);
			users = iu.findAll();
			umodel.setUsers(users);
			req.setAttribute("users", umodel);
			// req.getRequestDispatcher("/WEB-INF/vue/user/findAll.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/lister.us");
		} else if (req.getServletPath().equals("/modif.us") && req.getMethod().toLowerCase().equals("post")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			umodel.setId(id);
			umodel.setEmail(email);
			umodel.setPassword(password);
			User user = new User();
			user.setId(id);
			user.setEmail(email);
			user.setPassword(password);
			iu.update(user);
			users = iu.findAll();
			umodel.setUsers(users);
			req.setAttribute("users", umodel);
			// req.getRequestDispatcher("/WEB-INF/vue/user/findAll.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/lister.us");
		} else if (req.getServletPath().equals("/chercher.us")) {
			String motCle = req.getParameter("motCle");
			umodel.setKeyword(motCle);
			List<User> users = iu.findByKeyword(motCle);
			umodel.setUsers(users);
			req.setAttribute("users", umodel);
			req.getRequestDispatcher("/WEB-INF/vue/user/findAll.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
