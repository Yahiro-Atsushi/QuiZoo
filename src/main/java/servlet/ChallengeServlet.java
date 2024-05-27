package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.GetChallengeIds;
import businessObject.RemoveQuizId;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute(VarNames.game.name());
		@SuppressWarnings("unchecked")
		List<String> randomIdList = (List<String>) session.getAttribute(VarNames.randomIdList.name());

		/* --------gameがnullなら初回の処理-------- */
		if (game == null) {
			//リザルト表示する際に引き継いでおいたほうがいいのでセッションスコープに格納する
			GameMode mode = GameMode.CHALLENGE;
			//クイズテーブルの全Idをランダムに取得
			randomIdList = GetChallengeIds.execute();
			//ゲームインスタンスの生成
			game = SetChallengeLogic.execute();
			//クイズのセット
			game = SetNextQuizLogic.execute(randomIdList, game);
			//IDリストから取得したクイズのIDを削除
			randomIdList = RemoveQuizId.execute(game, randomIdList);
			int section = game.getQuizCount();
			Quiz quiz = game.getQuizzes().get(section);

			//リクエストサーブレットへ
			String question = quiz.getQuestionMsg();
			String button1 = quiz.getButtons().get(1);
			String button2 = quiz.getButtons().get(2);
			String button3 = quiz.getButtons().get(3);
			String button4 = quiz.getButtons().get(4);
			request.setAttribute("question", question);
			request.setAttribute("button1", button1);
			request.setAttribute("button2", button2);
			request.setAttribute("button3", button3);
			request.setAttribute("button4", button4);
			
			//セッションスコープへ格納
			session.setAttribute(VarNames.gameMode.name(), mode);//最初のみ
			session.setAttribute(VarNames.randomIdList.name(), randomIdList);
			session.setAttribute(VarNames.game.name(), game);

			RequestDispatcher rdp = request.getRequestDispatcher(Address.QUIZ.getAddress());
			rdp.forward(request, response);
			return;
		}
		/* --------初回の処理終了-------- */

		/* --------ここは2回目以降の処理開始-------- */
		RequestDispatcher rdp;

		int section = game.getQuizCount();
		boolean isCorrect = game.getIsCorrects().get(section);

		/* --------前回のクイズで正解の場合の処理-------- */
		if (isCorrect) {

			//次の問題を取得
			game = SetNextQuizLogic.execute(randomIdList, game);

			//IDリストから取得したクイズのIDを削除
			randomIdList = RemoveQuizId.execute(game, randomIdList);

			//リクエストサーブレットへ
			section = game.getQuizCount();
			Quiz nextQuiz = game.getQuizzes().get(section);
			String question = nextQuiz.getQuestionMsg();
			String button1 = nextQuiz.getButtons().get(1);
			String button2 = nextQuiz.getButtons().get(2);
			String button3 = nextQuiz.getButtons().get(3);
			String button4 = nextQuiz.getButtons().get(4);
			request.setAttribute("question", question);
			request.setAttribute("button1", button1);
			request.setAttribute("button2", button2);
			request.setAttribute("button3", button3);
			request.setAttribute("button4", button4);

			//quiz.jspへ
			rdp = request.getRequestDispatcher(Address.QUIZ.getAddress());
		} else {
			//ここは不正解の場合。

			/* --------データベースにゲームの結果を入力する処理-------- */
			ServletContext application = getServletContext();
			String userName = (String) application.getAttribute(VarNames.userName.name());
			SetChallengeJournalLogic.execute(userName, game);

			session.removeAttribute(VarNames.game.name());
			session.removeAttribute(VarNames.randomIdList.name());
			/* --------処理終了-------- */
			/* --------リクエスト先指定処理-------- */
			//リストに何も存在しない場合は問題切れでチャレンジ全問正解
			if (randomIdList == null || randomIdList.isEmpty())
				rdp = request.getRequestDispatcher(Address.CHALLENGE_CLEAR.getAddress());

			rdp = request.getRequestDispatcher(Address.CHALLENGE_FAULT.getAddress());
			/* --------処理終了-------- */
		}
		rdp.forward(request, response);

	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String input = (String) request.getParameter("input");
//
//		HttpSession session = request.getSession();
//		Game game = (Game) session.getAttribute("game");
//		int section = game.getQuizCount();
//
//		String answer = game.getQuizzes().get(section).getAnswer();
//		String text = ChoiceButtonTextLogic.execute(game, input);
//
//		request.setAttribute("answer", answer);
//		request.setAttribute("text", text);
//
//		// -------------------------------------------//
//		// 正解かどうか照合するロジック
//		game = JudgeLogic.execute(game, input);
//		session.setAttribute("game", game);
//		System.out.println(input);
//		System.out.println(game);
//		boolean isCollect = game.getIsCorrects().get(section);
//		// -------------------------------------------//
//
//		// 正解だったらcorrect.jspへ
//		if (isCollect) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher(Address.CORRECT.getAddress());
//			dispatcher.forward(request, response);
//		} else {
//			// 不正解ならnotCorrect.jsp
//			RequestDispatcher dispatcher = request.getRequestDispatcher(Address.NOT_CORRECT.getAddress());
//			dispatcher.forward(request, response);
//		}
//
//	}

}