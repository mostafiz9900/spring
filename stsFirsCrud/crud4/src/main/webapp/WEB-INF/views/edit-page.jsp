<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <form:form  action="/crud4/edit/${id}" method="post" modelAttribute="student">
   <div>
     
      <form:input type="hidden" path="id" />
    </div>
    
    <div class="form-group">
      <label for="names">Name:</label>
      <form:input path="name"  class="form-control" id="names" placeholder="Enter Name" />
    </div>
    <div class="form-group">
      <label for="emails">Email:</label>
      <form:input type="email" path="emain" class="form-control" id="emails" placeholder="Enter email" name="email"/>
    </div>
    <div class="form-group">
      <label for="pass">Password:</label>
      <form:input path="pass" type="password" class="form-control" id="pass" placeholder="Enter password" name="pass"/>
    </div>
    
    
    <form:button type="submit" class="btn btn-default">Submit</form:button>
  </form:form>
</div>

</body>
</html>