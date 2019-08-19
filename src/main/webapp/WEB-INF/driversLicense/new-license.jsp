<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!--important line to display jstl form -->    
<%@ page contentType="text/html; charset=UTF-8" %>  <!--important line to display emojis-->
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>
	<title></title>
</head>
<body>
	<h1>New License</h1>
	<!--FORM----------------------------------------- -->
	<form:form action="/licenses/new/add" method="POST" modelAttribute="DL">
		    <p>
		        <form:label path="person">Person</form:label>
		        <form:select path="person" class="form-control">
	                <c:forEach items="${persons}" var="person">
		                <c:if test="${person.DL.number == null }">
		                	<option value="${person.id}"> ${person.firstName} ${person.lastName}</option>
		                </c:if>
	                </c:forEach>
	            </form:select>
		    </p>
		    <p>
		        <form:label path="state">State</form:label>
		        <form:select path="state" class="form-control">
	                <c:forEach items="${states}" var="state">
		                <option value="${state}">${state}</option>
	                </c:forEach>
                </form:select>
		    </p>
		    <p>
		        <form:label path="expirationDate">Expiration Date</form:label>
		        <form:errors path="expirationDate"/>
		        <form:input path="expirationDate" type="date" class="form-control"/>
		    </p>
		    <input type="submit" value="Create"/>
		</form:form> 
</body>