package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.GameErrorMsgLogic;
import entity.JspAddress;
import entity.VarNames;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");

		Object parameter = request.getAttribute(VarNames.gameIsAbone.name());
		if (parameter != null) {
			boolean gameIsABone = (boolean) parameter;
			String gameIsABoneErrorMsg = GameErrorMsgLogic.execute(gameIsABone);
			request.setAttribute(VarNames.gameErrorMsg.name(), gameIsABoneErrorMsg);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(JspAddress.MAIN.getAddress());
		dispatcher.forward(request, response);
	}
}
