<%@ page language="java" session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ippoippo.morrison.dto.StartMe" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="_headBase.jsp"%>
	<title>show</title>
</head>
<body>

	<div class="row">
		<div class="span12">
			<a href="<%= request.getContextPath() %>/list">list</a>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<h1>show</h1>
		</div>
	</div>

	<form:form modelAttribute="startMe" action="create" method="post" cssClass="form-horizontal">
	<div class="control-group">
		<label class="control-label" for="id">id</label>
		<div class="controls">
			<form:input path="id" size="10" maxlength="8" readonly="true" />
			<spring:hasBindErrors name="startMe"><form:errors path="id" cssStyle="color:red" /></spring:hasBindErrors>
		</div>
		<label class="control-label" for="name">name</label>
		<div class="controls">
			<form:input path="name" size="24" maxlength="16"/>
			<spring:hasBindErrors name="startMe"><form:errors path="name" cssStyle="color:red" /></spring:hasBindErrors>
		</div>
	</div>
	<input id="crtBtn" type="submit" value="create" />
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
