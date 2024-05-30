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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Game;
import entity.VarNames;

/*
 * ゲームインスタンスに異常が発生した場合にメインサーブレットに遷移するフィルター
 * 「戻る」とかを押されるとこいつの出番。
 */
@WebFilter({"/JudgeServlet", "/TimeOutServlet"})
public class GameISABoneFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(new Date() +" / " + "GameISABoneFilter.doFilter activate.");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
			Game game = (Game)session.getAttribute(VarNames.game.name());
			String address = "/MainServlet";
			if(game == null) {
				RequestDispatcher rdp = request.getRequestDispatcher(address);
				httpRequest.setAttribute(VarNames.gameIsAbone.name(), true);
				rdp.forward(httpRequest, response);
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
