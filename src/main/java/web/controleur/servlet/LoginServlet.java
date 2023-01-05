package web.controleur.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.x.Ok;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.dao.IUser;
import metier.dao.Singleton;
import metier.dao.UserMetierImpl;
import metier.entities.User;
import web.model.UserModel;

@WebServlet(name = "ls", urlPatterns = { "/login", "/loginServlet" })
public class LoginServlet extends HttpServlet {
	Connection connection = null;
	IUser iu = null;

	@Override
	public void init() throws ServletException {
		connection = Singleton.getConnection();
		iu = new UserMetierImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getServletPath().equals(req.getContextPath()) || req.getServletPath().equals("/login")
				|| req.getServletPath().equals("/loginServlet")) {
			String message = "";
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			if (username.equals("") || password.equals("")) {
				message = "Informations erronées!!!";
				req.setAttribute("message", message);
				req.getRequestDispatcher("/index.jsp").include(req, resp);
			} else {
				try {
					HttpSession session = req.getSession();
					session.setAttribute("username", username);
					PreparedStatement ps = connection
							.prepareStatement("select username from login where username = ? and password = ?");
					ps.setString(1, username);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						List<User> users = iu.findAll();
						UserModel umodel = new UserModel();
						umodel.setUsers(users);
						req.setAttribute("users", umodel);
						req.getRequestDispatcher("/WEB-INF/vue/user/findAll.jsp").forward(req, resp);
					} else {
						message = "Informations erronées!!!";
						req.setAttribute("message", message);
						req.getRequestDispatcher("index.jsp").forward(req, resp);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
