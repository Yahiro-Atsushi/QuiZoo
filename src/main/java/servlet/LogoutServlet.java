package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Address;
import entity.VarNames;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//LogoutFilterに処理を委譲
//		//セッションスコープ破棄
//		request.getSession().invalidate();
		
		/* --------アプリケーションスコープからユーザー名を破棄-------- */
		ServletContext application = getServletContext();
		application.removeAttribute(VarNames.userName.name());
		/* --------処理終了-------- */
		
		//ログアウト画面へフォワード
		RequestDispatcher rdp = 
				request.getRequestDispatcher(Address.LOGOUT.getAddress());
		rdp.forward(request, response);
		
	}


}
