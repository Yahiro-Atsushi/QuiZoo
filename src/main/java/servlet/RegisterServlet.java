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

import businessObject.RegisterErrorCheckLogic;
import businessObject.RegisterLogic;
import businessObject.TrimLogic;
import entity.Address;
import entity.RegisterErrorMessage;
import entity.User;
import entity.VarNames;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() +" / " + getServletName() + ".doGet activate.");
		RequestDispatcher rdp = request.getRequestDispatcher(Address.REGISTER.getAddress());
		rdp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
 		throws ServletException, IOException {
		System.out.println(new Date() +" / " + getServletName() + ".doPost activate.");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//空白を削除する
		name = TrimLogic.execute(name);
		pass = TrimLogic.execute(pass);
		
		// アカウント登録処理
		//すでにアカウントが登録されていてもnull
		User user = RegisterLogic.execute(name, pass);
		
		if (user == null) {
			/* --------アカウント登録、ログイン失敗の時の処理--------*/
			
			RegisterErrorMessage errorMsg = RegisterErrorCheckLogic.execute(name, pass);
			request.setAttribute(VarNames.registerErrorMsg.name(), errorMsg);
			request.setAttribute(VarNames.name.name(), name);
			request.setAttribute(VarNames.pass.name(), pass);
			
			// register.jspにフォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(Address.REGISTER.getAddress());
			dispatcher.forward(request, response);
			
			/* --------処理終了-------- */
						
		} else {
			/* --------アカウント登録成功時の処理-------- */
			
			//アプリケーションスコープに保存
			ServletContext application = this.getServletContext();
			application.setAttribute("userName", user.getName());

			// main画面にフォワード
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(Address.MAIN.getAddress());
			dispatcher.forward(request, response);
			
			/* --------処理終了-------- */
			
		}
	

	}

}
