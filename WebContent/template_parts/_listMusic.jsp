<%@page import="model.Music"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="music-container row card ">
	<div class="card-body">
	
		<h2 class="text-primary">
			Listagem
			<i class="fas fa-list"></i> 
		</h2>
		
		
		<ul class="music-list row">
		 	<c:forEach items="${musics}" var="music">
		 		
				<li class="music-item-container  col-12 col-sm-6 mb-2"> 
				
					<a href="<%=request.getContextPath()%>/SingleMusicController?id=${music.getId()}"
						class="music-title text-mutted"> 
					 	${music.getName() } 
					 </a>
					 
					<div class="music-item d-flex"> 
						<audio controls>
							<source  
							   src="<%= request.getContextPath()%>${music.getFileURL()}"  
							   type="audio/mpeg" />
						</audio>
						 
						 
						 <a href="<%=request.getContextPath()%>/deleteMusic?id=${music.getId()}"
							class="music-title text-mutted "
							style="color:red"> 
						 	<i class="fas fa-trash"></i>
						 </a>
						 
					</div>
				</li> <!--  music item -->
				
			</c:forEach> 
		</ul> <!--  music list  -->
	</div><!--  ./ card-body -->
</section><!--  ./music-container  -->

		