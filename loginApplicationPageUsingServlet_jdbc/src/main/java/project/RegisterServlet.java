package project;

import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//fetching all the user data from request
		String name = req.getParameter("myname");
		String email = req.getParameter("myemail");
		String phone = req.getParameter("myphone");
		String dob = req.getParameter("mydob");
		String gender = req.getParameter("gender");
		String username = req.getParameter("uname");
		String password = req.getParameter("pass");
		
		//connection with DB
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","PHW#84#jeor");
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, dob);
			ps.setString(5, gender);
			ps.setString(6, username);
			ps.setString(7, password);
			
			ps.executeUpdate();
			
			resp.sendRedirect("login.html");
		} catch (Exception e) {
			e.printStackTrace();
			//resp.sendError(200, e.getMessage());
		}
	}

}
