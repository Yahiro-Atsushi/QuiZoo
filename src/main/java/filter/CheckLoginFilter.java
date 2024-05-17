package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import entity.Address;
import entity.VarNames;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
@WebFilter({ "/WelcomeServlet", "/MainServlet",
		"/LoginServlet", "/GameServlet", "/JournalServlet" })
public class CheckLoginFilter extends HttpFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CheckLoginFilter：処理開始");
		
		ServletContext application = request.getServletContext();
		String userName = (String) application.getAttribute(VarNames.userName.name());
		System.out.println("ユーザー名取得：" + userName);
		if (userName == null || userName.isEmpty()) {
			System.out.println("ユーザー名がnullです。トップ画面へ遷移");
			HttpServletRequest HttpRequest = (HttpServletRequest) request;
			RequestDispatcher rdp = HttpRequest.getRequestDispatcher(Address.INDEX.getAddress());
			rdp.forward(HttpRequest, response);
			return;
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
