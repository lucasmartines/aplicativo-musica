package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import model.Music;
import service.MusicService;
import service.MusicServiceImpl;
import util.RequestParamUtil;
import util.ResourceUtil;


@WebServlet("/saveMusic")
@MultipartConfig
public class MusicControllerPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MusicService musicService ;
	
	private Music validatedMusic;
	
	private Map<String,String> errors = new HashMap<>();
	
	@Override
	public void init() {
		
		musicService = new MusicServiceImpl();
		System.out.println("Mounted");
	}
	@Override
	public void destroy() {
		System.out.println("my servlet was unmonted");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
							
				request.setCharacterEncoding("UTF-8");
				
				Music newMusic = createMusicFromFormParameters(request);
				
				setIdForMusicIfIsInUpdateMode(request, newMusic);
				
				validateMusicNameOrAddError( newMusic , request ,response );
				
				newMusic.setFileURL( 
					uploadFileToDiscAndGetUrlOrAddError(request,response)		
				);
				
				saveOrUpdateUsingIdParam(request, response);
				
				ifExistsErrorsThenRedirectWithErrors(request,response);
				
				ifDontExistErrorsThenredirectToJspHome(request, response);
			
			
	}
	private void setIdForMusicIfIsInUpdateMode(HttpServletRequest request, Music newMusic)
			throws NumberFormatException {
		if( request.getParameter("id")!= null ) {
			newMusic.setId( Long.parseLong( request.getParameter("id") ) );
		}
	}
	private void ifExistsErrorsThenRedirectWithErrors(HttpServletRequest request , HttpServletResponse response) throws RuntimeException, ServletException, IOException {
		if( errors.size() > 0) {
						
			request.setAttribute("errorMap", errors );
			
			request.getRequestDispatcher(  "/" ).forward(request, response);
		}
	}
	
	
	private void ifDontExistErrorsThenredirectToJspHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if( errors.size() == 0) {
			response.sendRedirect( request.getContextPath() + "/");	
		}
	}
	
	private String uploadFileToDiscAndGetUrlOrAddError(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{
		try {
			
			if( ServletFileUpload.isMultipartContent(request)) 
			{
				
					Part part = request.getPart("music");
				    String nameOfUploadedFile = part.getSubmittedFileName();
				    
				    if( nameOfUploadedFile == null)  { nameOfUploadedFile = "random"; }
	
				    String absolutePath = ResourceUtil.getTheAbsolutePathOfFileUploaded(request);
				   
				    InputStream sourceOfMusicPart = part.getInputStream();
				    Path destinyOfMusicPart = Paths.get( absolutePath + File.separator+nameOfUploadedFile );
				    
				    
				    saveUploadedFileToDisc(sourceOfMusicPart, destinyOfMusicPart);
								    
				    return ResourceUtil.getResourceUriAndAddThisName( part.getSubmittedFileName() );
			}			
		}catch( Exception e ) {
			errors.put("arquivo", "O arquivo não pode ser enviado");
			
		}
		
		return "";
	}
	private void saveUploadedFileToDisc(InputStream sourceOfMusicPart, Path destinyOfMusicPart) throws IOException {
		Files.copy( sourceOfMusicPart , destinyOfMusicPart , StandardCopyOption.REPLACE_EXISTING );
	}

	private Music createMusicFromFormParameters(HttpServletRequest request) 
	{
	
		return new Music( 	
			request.getParameter("name") ,
			"" // music param, this will be filled by file upload
		);
	}

	private void saveMusicToDatabase(HttpServletRequest request, HttpServletResponse response) {
		
		
		musicService.saveMusic( validatedMusic );
		
	}
	private void updateMusicToDatabase(HttpServletRequest request ) {

		
		musicService.updateMusic( validatedMusic );
	}
		
	private void validateMusicNameOrAddError(Music newMusic , HttpServletRequest request, HttpServletResponse response ) 
	{
				
		if( request.getParameter("name").equals("") ) {
			errors.put( "error-name" , "Erro o nome não foi preenchido corretamente");
		}
		
		
		validatedMusic = newMusic;	
	}

	private void saveOrUpdateUsingIdParam(HttpServletRequest request, HttpServletResponse response) 
	{
		if( errors.size() == 0) {
			if( doParamIdExists(request) )
			{
				updateMusicToDatabase(request);
			}
			else {
				saveMusicToDatabase(request,response);
			}
		}
	}
	
	
	private boolean doParamIdExists(HttpServletRequest request) {
		return RequestParamUtil.getQueryParamFrom( "id", request ).isPresent();
	}
	

}
