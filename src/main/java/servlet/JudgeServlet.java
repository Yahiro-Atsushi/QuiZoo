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
import entity.JspAddress;
import entity.Game;


@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(new Date() +" / " + getServletName() + ".doPost activate.");
		
		request.setCharacterEncoding("UTF-8");
		String input = request.getParameter("choice");
		HttpSession session = request.getSession();
		Game game = (Game)session.getAttribute("game");
		int section = game.getQuizCount();
		
		System.out.println("     getQuizCount() : " + section);
		
		String answer = game.getQuizzes().get(section).getAnswer();
		String text = ChoiceButtonTextLogic.execute(game, input);
		
		request.setAttribute("answer", answer);
		request.setAttribute("text", text);
		
		// -------------------------------------------//
		// 正解かどうか照合するロジック
		game = JudgeLogic.execute(game, input);
		session.setAttribute("game", game);
		System.out.println("     ユーザーの入力：" + input);
		boolean correct = game.getIsCorrects().get(section);
		// -------------------------------------------//
		
		// 正解だったらcorrect.jspへ
		if (correct == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(JspAddress.CORRECT.getAddress());
			dispatcher.forward(request, response);
		} else {
		// 不正解ならnotCorrect.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher(JspAddress.NOT_CORRECT.getAddress());
			dispatcher.forward(request, response);
		}
	
	}

}
