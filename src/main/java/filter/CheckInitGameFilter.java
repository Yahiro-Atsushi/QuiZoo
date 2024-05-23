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

import entity.Address;
import entity.Game;
import entity.GameMode;
import entity.VarNames;

/**
 * Servlet Filter implementation class CheckAbendFilter
 */
@WebFilter("/GameServlet")
public class CheckInitGameFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		GameMode mode = (GameMode)httpRequest.getAttribute(VarNames.gameMode.name());
		
		HttpSession session = httpRequest.getSession();
		Game game = (Game)session.getAttribute(VarNames.game.name());
		
		RequestDispatcher rdp = null;
		
		if(mode == null && game == null) 
			rdp = request.getRequestDispatcher(Address.SELECT_GAMEMODE.getAddress());
		
		else if(mode != null && game == null)
			continue;
			
		
		
		if(mode == null)
			mode = (GameMode)session.getAttribute(VarNames.gameMode.name());
		/* --------チャレンジモードならChallengeServletへ遷移-------- */
		if(mode == GameMode.CHALLENGE)
			rdp = request.getRequestDispatcher("/ChallengeServlet");
		
		if(game == null)
			
		
		if(rdp != null)
			rdp.forward(httpRequest, response);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
