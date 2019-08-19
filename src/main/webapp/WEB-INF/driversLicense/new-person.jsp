<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!--important line to display jstl form -->   
<%@ page contentType="text/html; charset=UTF-8" %>  <!--important line to display emojis-->
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>
	<title>New Person</title>
</head>
<body>
	<div>
		<h1>New Person</h1>
		
		<form:form action="/persons/new/add" method="POST" modelAttribute="person">
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName" class="form-control"/>
		    </p>
		    <input type="submit" value="Create"/>
		</form:form> 
	</div>
</body>