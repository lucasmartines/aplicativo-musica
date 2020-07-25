package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Music;
import service.MusicService;
import service.MusicServiceImpl;

/**
 * Servlet implementation class MusicControllerGet
 */
@WebServlet(name = "MusicController", urlPatterns = "")
public class MusicControllerGet extends HttpServlet 
{
	
	private MusicService musicService ;
	
	public MusicControllerGet() {
		musicService = new MusicServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		getListOfMusicThenRedirectToJsp(request, response);
	}

	private void getListOfMusicThenRedirectToJsp(HttpServletRequest request, HttpServletResponse response) {
		
		List<Music> musics = findMusicByName(request);
		request.setAttribute("musics", musics );
		sendToJSP(request, response);
	}

	
	
	private void sendToJSP(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			request
			   .getRequestDispatcher("musicIndex.jsp")
			   .forward( request , response );	
			
			
		}catch( Exception e ) 
		{
			System.out.println( e );
		}
	}

	private List<Music> findMusicByName(HttpServletRequest request) {
				
		
		
		
		Optional<String> searchParameter = getQueryParamFrom(request);
		
		
		if( searchParameter.isPresent() ) {
				
			return musicService.searchMusicByName( searchParameter.get() );
		}				
		return musicService.getAllMusics();
	}

	/**
	 * Search parameter is the parameter q for example:
	 * www://your-url?q=search-music
	 * */
	
	Optional<String> getQueryParamFrom(HttpServletRequest request) {
		return Optional.ofNullable( request.getParameter("q") );
	}
	
	
	Optional<String> getQueryisPrivateFrom(HttpServletRequest request) {
		return Optional.ofNullable( request.getParameter("isPrivate") );
	}
	
	
	
	private static final long serialVersionUID = 1L;

}
