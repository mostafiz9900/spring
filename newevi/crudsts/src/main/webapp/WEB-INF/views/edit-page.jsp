<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<a href="http://localhost:8080/crud5">Student List</a>
  <h2>Horizontal form</h2>
  <form:form class="form-horizontal" action="/crudsts/edit/${id}" method="POST" modelAttribute="student">
    <div class="form-group">
      <label class="control-label col-sm-2">Name:</label>
      <div class="col-sm-10">
        <form:input path="name"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2">Gender:</label>
      <div class="col-sm-10">
      <form:radiobutton path="gender" value="M"/>Male 
      <form:radiobutton path="gender" value="F"/>Female 

      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Subject:</label>
      <div class="col-sm-10">
       <form:checkbox path="subject" value="Java"/>Java 
<form:checkbox path="subject" value="C++"/>C++ 
<form:checkbox path="subject" value=".Net"/>.Net
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Round:</label>
      <div class="col-sm-10">
    <form:select  path="round">
    <form:option value="">Select A Round</form:option>
    <form:option value="round-35">Round-35</form:option>
     <form:option value="round-36">Round-36</form:option>
      <form:option value="round-37">Round-37</form:option>
  </form:select>
   </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Notes:</label>
      <div class="col-sm-10">
     <form:textarea path="notes" rows="3" cols="20" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Username:</label>
      <div class="col-sm-10">
      <form:input path="userName"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Password:</label>
      <div class="col-sm-10">
       <form:password path="password" />

      </div>
    </div>
    
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <form:button type="submit" class="btn btn-default">Submit</form:button>
      </div>
    </div>
  </form:form>
</div>

</body>
</html>