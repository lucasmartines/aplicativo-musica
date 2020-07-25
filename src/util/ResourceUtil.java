package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class ResourceUtil {
	
	public static String getTheAbsolutePathOfFileUploaded(HttpServletRequest request) {
		 
		return request.getServletContext().getRealPath("") 
				+ File.separator + "resources" + File.separator + "musics";
	}
	
	/**
	 * retrieve /resources/music/{name}*/
	public static String getResourceUriAndAddThisName(String name ) {
		return "/resources/musics/" + name;
	}
}
