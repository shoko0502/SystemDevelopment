package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection users = null;
			try {
			request.setCharacterEncoding("utf-8");
			Class.forName("com.mysql.jdbc.Driver");
			users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUnicode=true&characterEncoding=utf8","root","");//← 1
			String id = request.getParameter("insertId");
			String name = request.getParameter("insertName");
			String picture = request.getParameter("insertPicture");
			Statement state = users.createStatement();
			state.executeUpdate("INSERT INTO user_table VALUE('" + id + "','" + name +
			"','" + picture + "')");
			state.close();
			users.close();
			response.sendRedirect("/select"); //UserSelectServletを呼び出す
			}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}
			}catch(SQLException e){
			e.printStackTrace();
			}
			}

}
