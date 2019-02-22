

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;














/**
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	   @SuppressWarnings("unused")
	PrintWriter out =response.getWriter();	
		
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		
		
		MVC_Package.MVC_Demo jb =new MVC_Package.MVC_Demo();
		jb.setUsername(username);
		jb.setPassword(password);
		
		request.setAttribute("bean", jb);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","");
			Statement st = con.createStatement();
			String query = "select password from Login_Data where username = '"+username+"'";
					ResultSet rs = st.executeQuery(query);
			
			String pass="";
			while(rs.next()){
				pass = rs.getString("password");
				
			}
			int success = 0;
			if(pass.equals(password)){
				success=-1;
			}
			if(success>0){
				RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("invalid.jsp");
				rd.forward(request, response);
			}
				
			con.close();
		}catch(Exception e){}
	
	
	
	
	
	
	}
	
	
	
	
	
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
