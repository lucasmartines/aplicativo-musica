<%
	String name = "";
	Long id = 0L;
	if( request.getAttribute("name") != null ){
		name = (String )request.getAttribute("name");
	}
	if( request.getAttribute("id") != null ){
		id = Long.parseLong( request.getAttribute("id").toString() );
	}
%>

<div class="form-group">
	<label class="text-primary" for="name"> Nome da Musica </label>
	<input type="hidden" value="<%= id %>" />
	<input 
		class="form-control" 
		name="name" 
		type="text" 
		placeholder="Coloque o nome da musica"
		value="<%= name %>"
		required/>
		
	<span class="text-red">  </span>
	
</div>
     			
<div class="form-group">
	<label class="text-primary" for="music"> Enviar Musica: </label>
	<input 
		class="form-control no-border" 
		name="music"
		type="file" 
		placeholder="Sua Musica"
		accept=".mp3"
		
	/>
	     				
	<span class="text-red">  </span>

</div>
     			