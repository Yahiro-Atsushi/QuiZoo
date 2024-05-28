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

import businessObject.ChoiceButtonTextLogic;
import businessObject.JudgeLogic;
import entity.Address;
import entity.Game;

@WebServlet("/TimeOutServlet")
public class TimeOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(new Date() +" / " + getServletName() + ".doGet activate.");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute("game");
		int nowSection = game.getQuizCount();
		String answer = game.getQuizzes().get(nowSection).getAnswer();
		String text = ChoiceButtonTextLogic.execute(game, answer);
		request.setAttribute("answer", answer);
		request.setAttribute("text", text);
		
		String timeOut = "時間切れ";
		// -------------------------------------------//
		// 正解かどうか照合するロジック
		game = JudgeLogic.execute(game, timeOut);
		session.setAttribute("game", game);
		System.out.println(game);
		// -------------------------------------------//

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.TIMEOUT.getAddress());
		dispatcher.forward(request, response);
	}

}
