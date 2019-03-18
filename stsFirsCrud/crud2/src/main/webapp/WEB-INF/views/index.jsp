<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<a href="http://localhost:8080/crud2/add">Add Customer</a>
  <h2>Striped Rows</h2>
  
  <h2>Message: ${successMsg}</h2>
  <p>The .table-striped class adds zebra-stripes to a table:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Update</th>
        <th>Delet</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="listStudent" items="${list}">
    
    <tr>
    <td>${listStudent.firstName}</td>
		<td>${listStudent.lastName}</td>
		<td>${listStudent.email}</td>
		<td>
		<a href="/crud2/edit/${listStudent.id}">Update</a>
		</td>
		<td>
		<a href="/crud2/del/${listStudent.id}">Delete</a>
		</td>
    </tr>
    
    </c:forEach>
     
     
    </tbody>
  </table>
</div>

</body>
</html>