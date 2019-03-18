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
<h1>
<a href="http://localhost:8008/crud6/add">Add Student</a>
</h1>
  <h2>Student List</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Name</th>
        <th>Gender</th>
         <th>Subject</th>
         <th>Round</th>
         <th>Notes</th>
          <th>Email</th>
        <th>Username</th>
        <th>password</th>
        <th>Update</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="sList" items="${list}">
     <tr>
        <td>${sList.name}</td>
        <td>${sList.gender}</td>
        <td>${sList.subject}</td>
         <td>${sList.round}</td>
         <td>${sList.notes}</td>
          <td>${sList.email}</td>
        <td>${sList.userName}</td>
        <td>${sList.password}</td>
        <td>
        <a href="/crud6/edit/${sList.id}">Update</a>
        </td>
         <td>
        <a href="/crud6/del/${sList.id}">Delete</a>
        </td>
      </tr>
     
    
    </c:forEach>
     
    </tbody>
  </table>
</div>
</body>
</html>