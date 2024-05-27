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

import entity.GameMode;
import entity.VarNames;

/**
 * Servlet Filter implementation class ChallengeModeFilter
 */
@WebFilter("/GameServlet")
public class ChallengeModeFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* --------チャレンジモードならChallengeServletへ遷移-------- */
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		GameMode mode = (GameMode)httpRequest.getAttribute(VarNames.gameMode.name());
		if(mode == null) {
			HttpSession session = httpRequest.getSession();
			mode = (GameMode)session.getAttribute(VarNames.gameMode.name());
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