<%@ page language="java" session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ippoippo.morrison.dto.StartMe" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="_headBase.jsp"%>
	<title>show</title>
</head>
<body>

	<div class="row">
		<div class="span12">
			<a href="<%= request.getContextPath() %>/startme/list">list</a>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<h1>show</h1>
		</div>
	</div>
	<div class="row">
		<div class="span1">id</div>
		<div class="span11"><c:out value="${startMe.id}" /></div>
	</div>
	<div class="row">
		<div class="span1">name</div>
		<div class="span11"><c:out value="${startMe.name}" /></div>
	</div>

	<form:form modelAttribute="startMe" action="../delete" method="post" cssClass="form-horizontal">
		<form:hidden path="id" />
		<input id="delBtn" type="submit" value="delete" />
	</form:form>

<script type="text/javascript">
<!--
$(function(){
	$('delBtn').click(function(){
		return confirm('Are your sure?');
	});
});
// -->
</script>

	<%@ include file="_footBase.jsp"%>
</body>
</html>
