<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Vertical (basic) form</h2>
  <h1>
<a href="http://localhost:8080/crud/add">Add Student</a>
</h1>
  <form:form action="log" method="post" modelAttribute="student">   
    <div class="form-group">
      <label>User Name:</label>
      <form:input path="userName"   class="form-control"/>
    </div>
     <div class="form-group">
      <label>Password:</label>
      <form:password path="password"  class="form-control"></form:password>
    </div>
  
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
</body>
</html>