package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.GameMode;
import entity.VarNames;

/**
 * Servlet Filter implementation class ChallengeModeFilter
 */
public class ChallengeModeFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* --------チャレンジモードならChallengeServletへ遷移-------- */
		System.out.println(new Date() +" / " + "ChallengeModeFilter.doFilter activate.");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		GameMode mode = (GameMode)session.getAttribute(VarNames.gameMode.name());
		if(mode == null) {
			
			mode = (GameMode)httpRequest.getAttribute(VarNames.gameMode.name());
		}
		
		if(mode == GameMode.CHALLENGE) {
			RequestDispatcher rdp = request.getRequestDispatcher("/ChallengeServlet");
			rdp.forward(request, response);
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
