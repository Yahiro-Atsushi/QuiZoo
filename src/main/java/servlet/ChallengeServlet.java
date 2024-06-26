package servlet;

import java.io.IOException;
import java.util.Date;
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
import entity.Game;
import entity.GameMode;
import entity.JspAddress;
import entity.Quiz;
import entity.VarNames;

@WebServlet("/ChallengeServlet")
public class ChallengeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");
		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute(VarNames.game.name());
		@SuppressWarnings("unchecked")
		List<String> randomIdList = (List<String>) session.getAttribute(VarNames.randomIdList.name());
		System.out.println("     randomIdList : " + randomIdList);

		/* --------gameがnullなら初回の処理-------- */
		if (game == null) {
			System.out.println("     初回の処理開始");
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

			//リクエストサーブレットへ格納
			request = setNextQuizToScope(request, game);

			//セッションスコープへ格納
			session.setAttribute(VarNames.gameMode.name(), mode);//最初のみ
			session.setAttribute(VarNames.randomIdList.name(), randomIdList);
			session.setAttribute(VarNames.game.name(), game);

			RequestDispatcher rdp = request.getRequestDispatcher(JspAddress.QUIZ.getAddress());
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
			//リストに何も存在しない場合は問題切れでチャレンジ全問正解
			if (randomIdList == null || randomIdList.isEmpty()) {
				/* --------データベースにゲームの結果を入力する処理-------- */
				ServletContext application = getServletContext();
				String userName = (String) application.getAttribute(VarNames.userName.name());
				SetChallengeJournalLogic.execute(userName, game);
				/* ---------------- */
				int answerCount = game.getQuizCount();
				request.setAttribute(VarNames.answerCount.name(), answerCount);
				session.removeAttribute(VarNames.game.name());
				session.removeAttribute(VarNames.randomIdList.name());
				rdp = request.getRequestDispatcher(JspAddress.CHALLENGE_CLEAR.getAddress());
				rdp.forward(request, response);
				return;
			}

			//次の問題を取得
			game = SetNextQuizLogic.execute(randomIdList, game);

			//IDリストから取得したクイズのIDを削除
			randomIdList = RemoveQuizId.execute(game, randomIdList);

			//リクエストスコープへ次のクイズを格納する
			request = setNextQuizToScope(request, game);

			//セッションスコープへ
			session.setAttribute(VarNames.game.name(), game);
			//quiz.jspへ
			rdp = request.getRequestDispatcher(JspAddress.QUIZ.getAddress());
		} else {
			//ここは不正解の場合。

			/* --------データベースにゲームの結果を入力する処理-------- */
			ServletContext application = getServletContext();
			String userName = (String) application.getAttribute(VarNames.userName.name());
			SetChallengeJournalLogic.execute(userName, game);
			/* ---------------- */
			final int FAULT_QUIZ_NUM = 1;
			int answerCount = game.getQuizCount() - FAULT_QUIZ_NUM;
			request.setAttribute(VarNames.answerCount.name(), answerCount);
			session.removeAttribute(VarNames.game.name());
			session.removeAttribute(VarNames.randomIdList.name());
			/* --------処理終了-------- */

			rdp = request.getRequestDispatcher(JspAddress.CHALLENGE_FAULT.getAddress());
		}
		rdp.forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private HttpServletRequest setNextQuizToScope(HttpServletRequest request, Game game) {
		int section = game.getQuizCount();
		System.out.println("     getQuizCount() : " + section);
		Quiz quiz = game.getQuizzes().get(section);

		String question = quiz.getQuestionMsg();
		String answer = quiz.getAnswer();
		String button1 = quiz.getButtons().get(1);
		String button2 = quiz.getButtons().get(2);
		String button3 = quiz.getButtons().get(3);
		String button4 = quiz.getButtons().get(4);
		request.setAttribute("question", question);
		request.setAttribute("answer", answer);
		request.setAttribute("button1", button1);
		request.setAttribute("button2", button2);
		request.setAttribute("button3", button3);
		request.setAttribute("button4", button4);

		return request;
	}
}
