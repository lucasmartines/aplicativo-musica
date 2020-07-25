<%
	String url = "";
	String uid = "";
	if( request.getAttribute("url") != null ){
		url = (String )request.getAttribute("url");
	}
	if( request.getAttribute("id") != null ){
		uid = (String )request.getAttribute("id").toString();
	}
%>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@include file="template_parts/_head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="template_parts/navbar.jsp" %>	


<div class="container">
	<nav class="breadcrumb w-100 my-2">
		<a 
			class="btn btn-outline-primary"
			href="<%= request.getContextPath() %>/"> Voltar </a>
	</nav>
</div>
<div class="container container-music-single " >
	<div class="audio">
		<audio controls>
			<source src="<%= request.getContextPath() + url %>" type="audio/mpeg" />
		</audio>
	</div>
	
	<h2> Dados da Musica </h2>
	<form
		 enctype="multipart/form-data"
		 method="post"
		 action="<%= request.getContextPath() %>/saveMusic?id=<%= uid %>"
		>
		<%@include file="template_parts/form.jsp" %>
		<button class="btn btn-primary" > Atualizar </button>
	</form>
</div>

<%@include file="template_parts/_footer.jsp" %>