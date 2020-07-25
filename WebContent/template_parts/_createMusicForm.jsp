<form
 id="musica-modal" 
 class="modal text-primary" 
 tabindex="-1" 
 role="dialog"
 enctype="multipart/form-data"
 method="post"
 action="<%= request.getContextPath() %>/saveMusic"
>


  <div 
     class="modal-dialog" 
     id="modal-music-creator" >
     
    <div class="modal-content">
    
      <div class="modal-header">
 
    
        <h5 class="modal-title">Insert Music</h5>

        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        
      </div> <!-- ./modal-header -->
            
      <div class="modal-body">
    		
       		<%@include file="form.jsp" %>	
       		
      </div> <!-- ./modal-body -->
      
      
      <div class="modal-footer">

        <button 
           type="submit" 
           class="btn btn-primary" >
			<i class="fa fa-save"></i> Salvar Musica
         </button>
         
      </div>
      
      
    </div> <!--  modal-content -->
  </div> <!--  ./modal-dialog -->
</form> <!--  modal -->