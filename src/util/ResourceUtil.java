package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class ResourceUtil {
	
	public static String getTheAbsolutePathOfFileUploaded(HttpServletRequest request) {
		
		
		
		String local = request.getServletContext().getRealPath("") 
				+ File.separator + "resources" + File.separator + "musics";
		
		File f = new File(local);
		
		if(!f.exists()) {
			f.mkdir();
		}
		
		return local ;
	}
	
	/**
	 * retrieve /resources/music/{name}*/
	public static String getResourceUriAndAddThisName(String name ) {
		return "/resources/musics/" + name;
	}
}
