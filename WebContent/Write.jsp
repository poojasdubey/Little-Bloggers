<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Write" method="post">
Title of your story <input type="text" name="title"/><br><br>

Select Category
<select name="category">
	<option>Ramayan</option>
	<option>Mahabharat</option>
	<option>Panchtantra</option>
	<option>Jaatak Tales</option>
	<option>Foreign Writers</option>
	<option>Others</option>
</select><br><br>

Write your story here<textarea name="content" style="width:500px;height:150px;"></textarea><br/><br/>

 time on server is<input type="text" name="storydate" value="<%= new java.util.Date() %>" >
 
<input type="submit" value="Submit Your Story">
 </form>
</body>
</html>