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
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		HttpSession session;        
		String n=request.getParameter("Password");  
		
		          
		try{  
		  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:orcl","hr","hr"); 
		  
		PreparedStatement ps=con.prepareStatement(  
		"select * from register where password=?");	//prepared statement holds the dbms query and returns 0/1  
		  ps.setString(1,n);
		
		int i=ps.executeUpdate();  //executeUpdate returns int type value
		if(i>0)  
		{
			session=request.getSession();
			/*	String sid=session.getId();
				out.println(sid);*/
		out.print("Login successfull");
		}
		else 
		   out.print("Login Failed");   
		          
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
