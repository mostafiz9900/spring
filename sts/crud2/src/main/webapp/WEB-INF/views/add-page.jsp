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
<a href="http://localhost:8080/crud2">Add student</a>
  
  <form:form  action="add" method="post" modelAttribute="student">
  <div>
     
      <form:input type="hidden" path="id" />
    </div>
  
    <div class="form-group">
      <label for="firstname">First Name:</label>
      <form:input  path="firstName" class="form-control" id="firstname" placeholder="Enter First name" name="firstname"/>
    </div>
      <div class="form-group">
      <label for="lastname">Last Name:</label>
      <form:input path="lastName" class="form-control" id="lastname" placeholder="Enter last nane" name="lastname"/>
    </div>
    
      <div class="form-group">
      <label for="email">Email:</label>
      <form:input type="email" path="email" class="form-control" id="email" placeholder="Enter email" name="email"/>
    </div>
  
    <form:button type="submit" class="btn btn-info">Submit</form:button>
  </form:form>
</div>

</body>
</html>