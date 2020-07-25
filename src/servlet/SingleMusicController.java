package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Music;
import service.MusicService;
import service.MusicServiceImpl;


@WebServlet("/SingleMusicController")
public class SingleMusicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MusicService musicService ;
	
	
	@Override
	public void init() {
		
		musicService = new MusicServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Music music = 
				musicService.getOneMusicById( getIdParamFromUrl(request) );
			
			redirectToHomeIfMusicIsNull(request, response, music);
			setAllAttributesToJspForm(request, music);
			redirectToJsp(request, response);	
		}
		catch( Exception e) {
			response.getOutputStream().print( e.getMessage());
		}
		
	}


	private long getIdParamFromUrl(HttpServletRequest request) throws NumberFormatException {
		return Long.parseLong(  request.getParameter( "id" ) );
	}


	private void redirectToHomeIfMusicIsNull(HttpServletRequest request, HttpServletResponse response, Music music)
			throws IOException {
		if( music == null ) {
			response.sendRedirect( request.getContextPath() + "" );
		}
	}


	private void redirectToJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request
		   .getRequestDispatcher( "/musicDetails.jsp")
		   .forward(request, response);
	}


	private void setAllAttributesToJspForm(HttpServletRequest request, Music music) {
		request.setAttribute( "name" , music.getName() );
		request.setAttribute( "id" , music.getId() );
		request.setAttribute( "url" , music.getFileURL() );
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
