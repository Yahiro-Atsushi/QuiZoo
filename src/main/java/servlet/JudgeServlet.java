package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.ChoiceButtonTextLogic;
import model.Game;
import model.JudgeLogic;


@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String input = request.getParameter("input");
		HttpSession session = request.getSession();
		Game game = (Game)session.getAttribute("game");
		
		String answer = game.getQuizzes().get(game.getQuizCount()).getAnswer();
		String text = ChoiceButtonTextLogic.execute(game, input);
		int nowSection = game.getQuizCount();
		
		request.setAttribute("answer", answer);
		request.setAttribute("text", text);
		
		// -------------------------------------------//
		// 正解かどうか照合するロジック
		game = JudgeLogic.execute(game, input);
		session.setAttribute("game", game);
		System.out.println(input);
		System.out.println(game);
		boolean collect = game.getIsCorrects().get(nowSection);
		// -------------------------------------------//
		
		// 正解だったらcorrect.jspへ
		if (collect == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(Address.CORRECT.getAddress());
			dispatcher.forward(request, response);
		} else {
		// 不正解ならnotCorrect.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher(Address.NOT_CORRECT.getAddress());
			dispatcher.forward(request, response);
		}
	
	}

}
