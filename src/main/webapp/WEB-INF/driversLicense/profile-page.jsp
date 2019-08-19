<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!--important line to display jstl form -->    
<%@ page contentType="text/html; charset=UTF-8" %>  <!--important line to display emojis-->
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>
	<title></title>
</head>
<body>
	<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
	<!--TABLE & OUTPUT----------------------------------------- -->
	<table class="table">
		<thead class="thead-dark">
		        <tr>
		            <th>License Number</th>
		            <th>State</th>
		            <th>Expiration Date</th>
		        </tr>
		</thead>
		<tbody>
		        <tr>
		            <td><c:out value="${person.DL.number}"/></td>
		            <td><c:out value="${person.DL.state}"/></td>
		            <td><c:out value="${person.DL.expirationDate}"/></td>
		            <td></td>
		        </tr>
		</tbody>
	</table>
</body>