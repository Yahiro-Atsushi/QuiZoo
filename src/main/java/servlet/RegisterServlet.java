package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.User;
import model.logic.LoginLogic;
import model.logic.RegisterLogic;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		// アカウント登録処理
		//すでにアカウントが登録されているかもここで確認する
		User error = RegisterLogic.execute(name, pass);
		
		//ログイン処理
		User user = LoginLogic.execute(name, pass);
				
		if (error != null || user != null) {
			/* --------アカウント登録、ログイン失敗の時の処理--------*/
			
			// register.jspにフォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(Address.REGISTER.getAddress());
			dispatcher.forward(request, response);
			
			/* --------処理終了-------- */
						
		} else {
			/* --------ログイン成功時の処理-------- */
			
			//アプリケーションスコープに保存
			ServletContext application = this.getServletContext();
			application.setAttribute("userName", name);

			// main画面にフォワード
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(Address.MAIN.getAddress());
			dispatcher.forward(request, response);
			
			/* --------処理終了-------- */
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
 		throws ServletException, IOException {
		

	}

}
