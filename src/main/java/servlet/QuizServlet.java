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


@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Game game = (Game)session.getAttribute("game");
		String question = game.getQuizzes().get(game.getQuizCount()).getQuistionMsg();
		String button1 = game.getQuizzes().get(game.getQuizCount()).getButtons().get(1);
		String button2 = game.getQuizzes().get(game.getQuizCount()).getButtons().get(2);
		String button3 = game.getQuizzes().get(game.getQuizCount()).getButtons().get(3);
		String button4 = game.getQuizzes().get(game.getQuizCount()).getButtons().get(4);
		request.setAttribute("question", question);
		request.setAttribute("button1", button1);
		request.setAttribute("button2", button2);
		request.setAttribute("button3", button3);
		request.setAttribute("button4", button4);
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/quiz.jsp");
		dispatcher.forward(request, response);
	}

}
