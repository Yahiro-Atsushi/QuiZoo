package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.ResultLogic;
import businessObject.SetGameLogic;
import businessObject.SetGameModeLogic;
import businessObject.SetJournalLogic;
import entity.Game;
import entity.GameMode;
import entity.JspAddress;
import entity.Quiz;
import entity.VarNames;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + "GameServlet.doGet activate.");
		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute(VarNames.game.name());
		RequestDispatcher rdp;

		/* --------gameがnullなら初回の処理-------- */
		if (game == null) {

			//難易度選択画面からリクエストスコープに格納されている
			String gameMode = request.getParameter(VarNames.gameMode.name());
			GameMode mode = SetGameModeLogic.execute(gameMode);
			System.out.println("     request gameMode is " + mode);

			//なければメイン画面からのリクエスト。セッションスコープから取り出す。
			if (mode == null) {
				mode = (GameMode) session.getAttribute(VarNames.gameMode.name());
			}
			//ここでnullorCHALLENGEの場合は本当に想定外
			//			if (mode == null) {
			//				rdp = request.getRequestDispatcher("/MainServlet");
			//				rdp.forward(request, response);
			//				return;
			//			} else if (mode == GameMode.CHALLENGE) {
			//				rdp = request.getRequestDispatcher("/ChallengeServlet");
			//				rdp.forward(request, response);
			//				return;
			//			}

			//履歴表示する際に引き継いでおいたほうがいいのでセッションスコープに格納する
			session.setAttribute(VarNames.gameMode.name(), mode);
			game = SetGameLogic.execute(mode);
		}

		/* --------初回の処理終了-------- */
		//		if (game.getMode() == GameMode.CHALLENGE) {
		//			rdp = request.getRequestDispatcher("/ChallengeServlet");
		//			rdp.forward(request, response);
		//			return;
		//		}

		session.setAttribute(VarNames.game.name(), game);

		/* --------ここから継続用の処理開始-------- */

		/* --------クイズが全問終わっているか判定-------- */
		/* ----10問終えるまではクイズ画面へ遷移する際の処理 ---- */
		if (game.getQuizCount() < game.getMode().getQuizNum()) {

			//次の問題を取得
			final int STEP = 1;
			int next = game.getQuizCount() + STEP;
			game.setQuizCount(next);

			//リクエストサーブレットへ
			request = setQuizToRequest(request, game);

			//quiz.jspへ
			rdp = request.getRequestDispatcher(JspAddress.QUIZ.getAddress());
			/* ----リザルト画面へ遷移する際の処理---- */
		} else {
			//10問終えていたらresult.jspへ

			//---------------------------------------------------//
			// 結果を(1, "正解")のように表示させるロジック
			Map<Integer, String> result = ResultLogic.execute(game);
			request.setAttribute(VarNames.result.name(), result);
			//---------------------------------------------------//

			/* --------データベースにゲームの結果を入力する処理-------- */
			ServletContext application = getServletContext();
			String userName = (String) application.getAttribute(VarNames.userName.name());
			SetJournalLogic.execute(userName, game, result);

			session.removeAttribute(VarNames.game.name());
			rdp = request.getRequestDispatcher(JspAddress.RESULT.getAddress());
		}
		/* --------リクエスト先処理終了-------- */

		rdp.forward(request, response);

	}

	private HttpServletRequest setQuizToRequest(HttpServletRequest request, Game game) {
		
		int next = game.getQuizCount();
		Quiz quiz = game.getQuizzes().get(next);
		
		String question = quiz.getQuestionMsg();
		String button1 = quiz.getButtons().get(1);
		String button2 = quiz.getButtons().get(2);
		String button3 = quiz.getButtons().get(3);
		String button4 = quiz.getButtons().get(4);
		String answer = quiz.getAnswer();
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
		request.setAttribute("answer", answer);
		
		return request;
	}
}
