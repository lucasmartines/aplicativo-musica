<% 
String q = "";

if( request.getParameter("q") != null  ){
	q = request.getParameter("q") ;
}
%>

<form class="row">
	<div class="input-group mb-3 px-2">
	  <input 
	  		type="text" 
	  		class="form-control" 
	  		placeholder="Your Music" 
	  		aria-label="Recipient's for searching music" 
	  		aria-describedby="button-addon2"
	  		name="q" 
	  		value="<%= q %>" />
	  		
	  		
	  <div class="input-group-append">
	    <button class="btn btn-outline-secondary bg-white" type="submit">
			<i class="fa fa-search"></i>
		</button>
	    <a class="btn btn-outline-secondary bg-white" href="<%= request.getContextPath() +"/" %>">
			<i class="fa fa-times"></i>
		</a>
		
	  </div>
	</div>
</form>