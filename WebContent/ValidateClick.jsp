<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
 // boolean b=session.isNew();

/* if(b==true)
{
//	sid=session.getId();
	session.setAttribute("sessionid",sid);
	//out.println(sid);
	response.sendRedirect("Login.jsp");
	}
if(b==false && (sid ==null))
{
	response.sendRedirect("Login.jsp");
	out.println("continue");

	} */

//session.invalidate();
HttpSession hs=request.getSession(false);
	if(hs==null)
	{
		out.println("session not alive");
	}
	else
		out.println("session alive :"+hs);
%>