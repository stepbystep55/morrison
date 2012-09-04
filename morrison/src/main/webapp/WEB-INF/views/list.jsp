<%@ page language="java" session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ippoippo.morrison.dto.StartMe" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="_headBase.jsp"%>
	<title>list</title>
</head>
<body>

	<h1>list</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
			</tr>
		</thead>
		<c:if test="${(startMeList != null) && (fn:length(startMeList) != 0)}">
			<tbody>
				<c:forEach items="${startMeList}" var="startMe">
				<tr>
					<td>
						<a href="<%= request.getContextPath() %>/startme/get/${startMe.id}"><c:out value="${startMe.id}" /></a>
					</td>
					<td>
						<c:out value="${startMe.name}" />
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</table>

	<form action="new" method="post">
		<input type="submit" value="new" />
	</form>

	<%@ include file="_footBase.jsp"%>
</body>
</html>
