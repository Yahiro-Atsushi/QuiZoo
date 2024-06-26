package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.JspAddress;
import entity.VarNames;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");

		/* --------アプリケーションスコープからユーザー名を破棄-------- */
		ServletContext application = getServletContext();
		application.removeAttribute(VarNames.userName.name());
		/* --------処理終了-------- */

		//ログアウト画面へフォワード
		RequestDispatcher rdp = request.getRequestDispatcher(JspAddress.LOGOUT.getAddress());
		rdp.forward(request, response);

	}

}
