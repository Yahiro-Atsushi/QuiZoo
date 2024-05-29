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

import businessObject.SetGameModeLogic;
import entity.Game;
import entity.GameMode;
import entity.VarNames;

/*
 *  前回のゲームが異常終了したか検知する機能 
 *  セッションスコープにGameインスタンスが存在し、かつゲーム中フラグがfalseの場合に起動される。
 */
public class CheckAbendFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(new Date() +" / " + "CheckAbendFilter.doFilter activate.");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		String gameMode = request.getParameter(VarNames.gameMode.name());
		GameMode reqMode = SetGameModeLogic.execute(gameMode);
		GameMode sesMode = 
				(GameMode)session.getAttribute(VarNames.gameMode.name());
		Game game = (Game)session.getAttribute(VarNames.game.name());
		System.out.println("     game is " + game);
		System.out.println("     request mode is " + reqMode);
		System.out.println("     session mode is " + sesMode);
		boolean isInProgress = (boolean)session.getAttribute("isInProgress");
		String address = null;
		
		if(isInProgress) {
			System.out.println("in progress.");
			if(game == null && sesMode == null) {
				System.out.println("game & mode is null.");
//				forward(request, response, "/SelectGameModeServlet");
//				return;
			}
		}else {
			System.out.println("not in progress.");
			if(game == null && reqMode == null && sesMode == null) {
				System.out.println("game & mode is null.");
				address = "/SelectGameModeServlet";
				forward(httpRequest, response, address);
				return;
			}
			if(game != null) {
				System.out.println("game is not null.");
				address = "/AbendGameServlet";
				forward(httpRequest, response, address);
				return;
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
