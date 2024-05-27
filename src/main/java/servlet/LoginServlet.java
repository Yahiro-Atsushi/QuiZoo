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

import businessObject.LoginErrorCheckLogic;
import businessObject.LoginLogic;
import entity.Address;
import entity.LoginUserErrorMessage;
import entity.User;
import entity.VarNames;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() +":" + getServletName() + ".doGet activate.");
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(Address.REGISTER.getAddress());
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() +":" + getServletName() + ".doPost activate.");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		// ログイン処理
		User user = LoginLogic.execute(name, pass);
		
		if (user == null) {
			/* --------ログイン失敗の時の処理--------*/
			
			LoginUserErrorMessage errorMsg = LoginErrorCheckLogic.execute(user, name, pass);
			request.setAttribute(VarNames.loginErrorMsg.name(), errorMsg);
			request.setAttribute(VarNames.name.name(), name);
			request.setAttribute(VarNames.pass.name(), pass);
			
			// indexにフォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(Address.INDEX.getAddress());
			dispatcher.forward(request, response);
			
			/* --------処理終了-------- */
		} else {
			/* --------ログイン成功時の処理-------- */
			
			//アプリケーションスコープに保存
			ServletContext application = this.getServletContext();
			application.setAttribute(VarNames.userName.name(), user.getName());

			// main画面にフォワード
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(Address.MAIN.getAddress());
			dispatcher.forward(request, response);
			
			/* --------処理終了-------- */
			
		}
	}

}
