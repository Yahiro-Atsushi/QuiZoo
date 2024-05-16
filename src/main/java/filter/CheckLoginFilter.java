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
@WebFilter("/WelcomeServlet, /MainServlet, /LoginServlet, /GameServlet")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		ServletContext application = getServletContext();
		String userName = (String)application.getAttribute(VarNames.userName.name());
		
		if(userName == null || userName.isEmpty()) {
			HttpServletRequest HttpRequest = (HttpServletRequest)request;
			RequestDispatcher rdp = 
					HttpRequest.getRequestDispatcher(Address.INDEX.getAddress());
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
