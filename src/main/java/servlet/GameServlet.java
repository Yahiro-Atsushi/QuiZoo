package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.Game;
import model.GameMode;
import model.Quiz;
import model.ResultLogic;
import model.SetGameLogic;
import model.VarNames;


@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Game game = (Game)session.getAttribute(VarNames.game.name());
		
		/* --------gameがnullなら初回の処理-------- */
		if(game == null) {
			GameMode mode = (GameMode)request.getAttribute(VarNames.gameMode.name());
			
			//GameModeがnullならチュートリアル
			if(mode == null) {
				mode = GameMode.TUTORIAL;
			}
			
			game = SetGameLogic.execute(mode);
		}
		/* --------初回の処理終了-------- */
		
		session.setAttribute(VarNames.game.name(), game);
		RequestDispatcher rdp;
		
		/* --------クイズが全問終わっているか判定-------- */
		/* ----10問終えるまではクイズ画面へ遷移する際の処理 ---- */
		if(game.getQuizCount() <= 10) {
			
			//次の問題を取得
			int section = game.getQuizCount();
			Quiz quiz = game.getQuizzes().get(section);
			
			//リクエストサーブレットへ
			String question = quiz.getQuistionMsg();
			String button1 = quiz.getButtons().get(1);
			String button2 = quiz.getButtons().get(2);
			String button3 = quiz.getButtons().get(3);
			String button4 = quiz.getButtons().get(4);
			
			request.setAttribute("question", question);
			request.setAttribute("button1", button1);
			request.setAttribute("button2", button2);
			request.setAttribute("button3", button3);
			request.setAttribute("button4", button4);
			
			//quiz.jspへ
			rdp = request.getRequestDispatcher(Address.QUIZ.getAddress());
			
		/* ----リザルト画面へ遷移する際の処理---- */
		}else {
			//10問終えていたらresult.jspへ
			//---------------------------------------------------//
			// 結果を(1, "正解")のように表示させるロジック
			Map<Integer, String> result = ResultLogic.execute(game);
			session.setAttribute("result", result);
			//---------------------------------------------------//
			
			session.removeAttribute(VarNames.game.name());
			rdp = request.getRequestDispatcher(Address.RESULT.getAddress());
			
		}
		/* --------リクエスト先処理終了-------- */
		
		rdp.forward(request, response);

	}
}
