package util;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

public class RequestParamUtil 
{

	public static Optional<String> getQueryParamFrom( String paramName ,HttpServletRequest request ) {
		return Optional.ofNullable( request.getParameter( paramName ) );
	}
}
