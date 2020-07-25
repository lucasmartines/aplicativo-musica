package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Music;
import util.DatabaseUtils;

@WebServlet("/deleteMusic")
public class MusicControllerDelete extends HttpServlet {

	@Override
	public void doGet( HttpServletRequest req, HttpServletResponse res ) 
		throws ServletException, IOException  {
		
		Long id = Long.parseLong( req.getParameter("id") ) ;
		
		EntityManager em = DatabaseUtils.getManager();
		
		em.getTransaction().begin();
		
		Music founded = em.find( Music.class ,  id );
		
		
		em.remove( founded );
		em.getTransaction().commit();
		
		if( founded == null) {
			req.getRequestDispatcher("/music-jsp").forward( req, res );
		}
		else {
			res.getOutputStream().println("fail");
			res.getOutputStream().println( id );
			 
		}
		
		res.sendRedirect( req.getContextPath() + "/");
		
		
		
	}
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 198348387L;
	
}
