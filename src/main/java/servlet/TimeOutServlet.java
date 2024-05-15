package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Game;

@WebServlet("/TimeOutServlet")
public class TimeOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Game game = (Game)session.getAttribute("game");
		int nowSection = game.getQuizCount();
		String answer = game.getQuizzes().get(nowSection).getAnswer();
		String text = game.getQuizzes().get(nowSection).getButtonTexts().get(nowSection);
		request.setAttribute("answer", answer);
		request.setAttribute("text", text);
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/timeOut.jsp");
		dispatcher.forward(request, response);
	}

}
