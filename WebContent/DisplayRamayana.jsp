<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Little Blogger</title>
</head>
<body>
<% 
try{  
	  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr"); 
  
    PreparedStatement ps=con.prepareStatement( "select * from story where category=?");	//prepared statement holds the dbms query and returns 0/1  
    ps.setString(1,request.getParameter("category"));
    ResultSet rs=ps.executeQuery();
    while(rs.next())
   {
//	out.println(rs.getString("category")+""+rs.getString("title")+""+rs.getString("content"));
	String s=rs.getString("title");
	out.println("<a href=New.jsp?title="+s+">"+s+"</a><br/>");
	}

}
catch(Exception ex)
{}
%>

</body>
</html>