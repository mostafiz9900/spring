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
<h1>
<a href="http://localhost:8080/crud/add">Add Student</a>
</h1>
<h1>
<a href="http://localhost:8080/crud/list">List Student</a>
</h1>
  <h2>Student List</h2>
            
  <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>UserName</th>
         <th>Password</th>
         <th>Edit</th>
         <th>Delete</th>          
      </tr>
    </thead>
    <tbody>
    <c:forEach var="sList" items="${list}">
    <tr>
        <td>${sList.id}</td>
        <td>${sList.name}</td>
        <td>${sList.userName}</td>
        <td>${sList.password}</td> 
        <td>
        <a href="/crud/edit/${sList.id}">Update</a>
        </td>  
         <td>
        <a href="/crud/del/${sList.id}">Delete</a>
        </td>       
      </tr>
    </c:forEach>
      
      
    </tbody>
  </table>
</div>
</body>
</html>