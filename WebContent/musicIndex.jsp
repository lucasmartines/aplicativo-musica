<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="template_parts/_head.jsp" %>
<%@include file="template_parts/navbar.jsp" %>	

	<div class="container">
	
		<section class="create-music row my-2">
			<div class="card card-template col">
				
				<article class=" d-md-flex"> 
				
					<h2 class="text-white ">
						Nova Musica
						<i class="fas fa-play"></i> 
					</h2>
					
					<button class="btn btn-primary mb-3 ml-md-auto "  
					        data-toggle="modal" data-target="#musica-modal"  >
						<i class="fas fa-plus"></i> 
						Criar Uma Musica
					</button>	

				</article>
				<div class="col-12 col-sm-10">
					<%@include file="template_parts/_buscador.jsp" %>
				</div>
			</div>
		</section>
		
		<section class="card-template row card">
			<div class="card-body col">
				<div class=" mt-md-5 pt-md-2" > 
					<h2 class="text-primary">
						Aplicativo de Musica
						<i class="fas fa-podcast"></i> 
					</h2>
					<p class="text-secondary"> Guarde suas musicas aqui!</p>	
				</div> 
				
				
			</div><!--  fim card body -->
		</section>	
		<!-- fim do header do aplicativo de musica -->
		
		<%@include file="template_parts/_listMusic.jsp" %>

		<c:if test="true">
			show me
		</c:if>
	</div>
	
	
<%@include file="template_parts/_createMusicForm.jsp" %>
<%@include file="template_parts/_footer.jsp" %>