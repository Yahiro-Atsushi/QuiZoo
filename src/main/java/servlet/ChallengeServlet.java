package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.ChoiceButtonTextLogic;
import businessObject.JudgeLogic;
import businessObject.ResultLogic;
import businessObject.SetChallengeJournalLogic;
import businessObject.SetChallengeLogic;
import businessObject.SetNextQuizLogic;
import entity.Address;
import entity.Game;
import entity.GameMode;
import entity.Quiz;
import entity.VarNames;

/**
 * Servlet implementation class ChallengeServlet
 */
@WebServlet("/ChallengeServlet")
public class ChallengeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute(VarNames.game.name());

		/* --------gameがnullなら初回の処理-------- */
		if (game == null) {
			GameMode mode = GameMode.CHALLENGE;
			//リザルト表示する際に引き継いでおいたほうがいいのでセッションスコープに格納する
			session.setAttribute(VarNames.gameMode.name(), mode);
			game = SetChallengeLogic.execute();
			session.setAttribute(VarNames.game.name(), game);
			RequestDispatcher rdp = 
					request.getRequestDispatcher(Address.QUIZ.getAddress());
			rdp.forward(request, response);
			return;
		}
		/* --------初回の処理終了-------- */
		
		/* --------2回目以降の処理開始-------- */
		RequestDispatcher rdp;
		
		int section = game.getQuizCount();
		boolean isCorrect = game.getIsCorrects().get(section);
		
		/* --------前回のクイズで正解の場合の処理-------- */
		if (isCorrect) {

			//次の問題を取得
			int next = section + 1;
			Quiz nextQuiz  = SetNextQuizLogic.execute(game.getQuizzes());
			game.getQuizzes().put(next, nextQuiz);
			game.getIsCorrects().put(next, false);

			//リクエストサーブレットへ
			String question = nextQuiz.getQuistionMsg();
			String button1 = nextQuiz.getButtons().get(1);
			String button2 = nextQuiz.getButtons().get(2);
			String button3 = nextQuiz.getButtons().get(3);
			String button4 = nextQuiz.getButtons().get(4);
			System.out.println("質問テスト" + question);
			System.out.println("ボタン1テスト" + button1);
			System.out.println("ボタン2テスト" + button2);
			System.out.println("ボタン3テスト" + button3);
			System.out.println("ボタン4テスト" + button4);
			request.setAttribute("question", question);
			request.setAttribute("button1", button1);
			request.setAttribute("button2", button2);
			request.setAttribute("button3", button3);
			request.setAttribute("button4", button4);

			//quiz.jspへ
			rdp = request.getRequestDispatcher(Address.QUIZ.getAddress());
		/* ----リザルト画面へ遷移する際の処理---- */
		} else {
			//間違えていたらresult.jspへ

			//---------------------------------------------------//
			// 結果を(1, "正解")のように表示させるロジック
			Map<Integer, String> result = ResultLogic.execute(game);
			session.setAttribute("result", result);
			//---------------------------------------------------//

			/* --------データベースにゲームの結果を入力する処理-------- */
			ServletContext application = getServletContext();
			String userName = (String) application.getAttribute(VarNames.userName.name());
			SetChallengeJournalLogic.execute(userName, game, result);

			session.removeAttribute(VarNames.game.name());
			rdp = request.getRequestDispatcher(Address.CHALLENGE_RESULT.getAddress());

		}
		/* --------リクエスト先処理終了-------- */

		rdp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = (String)request.getParameter("input");


		HttpSession session = request.getSession();
		Game game = (Game)session.getAttribute("game");
		int section = game.getQuizCount();
		
		String answer = game.getQuizzes().get(section).getAnswer();
		String text = ChoiceButtonTextLogic.execute(game, input);
		
		request.setAttribute("answer", answer);
		request.setAttribute("text", text);
		
		// -------------------------------------------//
		// 正解かどうか照合するロジック
		game = JudgeLogic.execute(game, input);
		session.setAttribute("game", game);
		System.out.println(input);
		System.out.println(game);
		boolean isCollect = game.getIsCorrects().get(section);
		// -------------------------------------------//
		
		// 正解だったらcorrect.jspへ
		if (isCollect) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(Address.CORRECT.getAddress());
			dispatcher.forward(request, response);
		} else {
		// 不正解ならnotCorrect.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher(Address.NOT_CORRECT.getAddress());
			dispatcher.forward(request, response);
		}
		
	}

}
