package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * ログアウトの際にセッションスコープを破棄するフィルター。
 */
@WebFilter("/LogoutServlet")
public class LogoutFilter extends HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(new Date() +" / " + "LogoutFilter.doFilter activate.");
		//ログアウト時にセッションスコープを破棄する。
		HttpServletRequest httpRequest =
				(HttpServletRequest)request;
		
		HttpSession session = httpRequest.getSession();
		session.invalidate();
		System.out.println("     セッションスコープが破棄されました。");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
