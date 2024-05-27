package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Game;
import entity.GameMode;
import entity.VarNames;

/**
 * Servlet Filter implementation class CheckAbendFilter
 */
@WebFilter("/GameServlet")
public class CheckAbendFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		GameMode reqMode = 
				(GameMode)httpRequest.getAttribute(VarNames.gameMode.name());
		GameMode sesMode = 
				(GameMode)session.getAttribute(VarNames.gameMode.name());
		Game game = (Game)session.getAttribute(VarNames.game.name());
		boolean isInProgress = (boolean)session.getAttribute("isInProgress");
		
		if(isInProgress) {
			if(game == null && sesMode == null) {
				forward(request, response, "/SelectGameModeServlet");
			}
		}else {
			if(game == null && reqMode == null && sesMode == null) {
				forward(httpRequest, response, "/SelectGameModeServlet");
			}
			if(game != null) {
				forward(httpRequest, response, "/AbendGameServlet");
			}
		}
		chain.doFilter(request, response);
	}

	private void forward(ServletRequest request, ServletResponse response, String address) throws IOException, ServletException  {
		RequestDispatcher rdp = request.getRequestDispatcher(address);
		rdp.forward(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
