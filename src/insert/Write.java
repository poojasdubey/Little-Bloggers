package insert;

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


@WebServlet("/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Write() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession hs=request.getSession(false);
			PrintWriter out=response.getWriter();
			
			String title=request.getParameter("title");
			String category=request.getParameter("category");
			String content=request.getParameter("content");
			String time=request.getParameter("storydate");
			String userid=(String) hs.getAttribute("userid");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			PreparedStatement ps=con.prepareStatement("insert into story(title,category,content) values(?,?,?)");	//prepared statement holds the dbms query and returns 0/1  
			ps.setString(1,title);
			ps.setString(2,category);
			ps.setString(3,content);
			//ps.setString(4,time);
					
					int i=ps.executeUpdate();  //executeUpdate returns int type value
					if(i>0)  
					{
							out.print("Data inserted successfully");
					}
					else 
					   out.print("Data not entered");   
				}
		
		catch(Exception ex)
		{
			out.println(ex);
		}
			
		}
	}


