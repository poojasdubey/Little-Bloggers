package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
         
		String n=request.getParameter("Name");  
	    String p=request.getParameter("Password");  
		String e=request.getParameter("Email");  
		//String id="userid_inc.nextval";
		          
		try{  
		  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:orcl","hr","hr"); 
		
		PreparedStatement ps=con.prepareStatement("insert into register values(userid_inc.nextval,?,?,?,sysdate)");	//prepared statement holds the dbms query and returns 0/1  
		  
	//	ps.setString(1,id);  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		          
		int i=ps.executeUpdate();  //executeUpdate returns int type value
		if(i>0)  
		out.print("You are successfully registered...");  
		else 
		   out.print("You are not successfully registered...");   
		          
		}catch (Exception e2) {out.println(e2);}  
		          
		out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
