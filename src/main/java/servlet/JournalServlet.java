package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.GetJournalLogic;
import businessObject.GetJournalPortLogic;
import businessObject.SetGameModeLogic;
import database.QuizDao;
import entity.GameMode;
import entity.Journal;
import entity.JournalPort;
import entity.JspAddress;
import entity.Quiz;
import entity.VarNames;

@WebServlet("/JournalServlet")
public class JournalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");
		//----------------------------------------------//
		// ログインしているユーザーの日付・正解数・履歴IDを持ってくるロジック
		ServletContext application = getServletContext();
		String userName = (String) application.getAttribute(VarNames.userName.name());
		List<JournalPort> journalPortList = GetJournalPortLogic.execute(userName);
		// System.out.println(journal);
		HttpSession session = request.getSession();
		session.setAttribute("journalPort", journalPortList);
		//----------------------------------------------//

		/* --------履歴がなかった場合にフォワード先を分岐する処理-------- */

		RequestDispatcher dispatcher = request.getRequestDispatcher(JspAddress.JOURNAL_LIST.getAddress());
		if (journalPortList.isEmpty()) {
			dispatcher = request.getRequestDispatcher(JspAddress.EMPTY_JOURNAL_LIST.getAddress());
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doPost activate.");
		//----------------------------------------------//
		// 踏まれたリンクのボタンからID検索してJournalインスタンスが返ってくるロジック
		// Journalインスタンス（Quizマップ・日付・resultマップ（正解or不正解）・ユーザー名・履歴ID）
		String journalId = request.getParameter("journalId");
		Journal journal = GetJournalLogic.execute(journalId);

		Map<Integer, Quiz> quizMap = new TreeMap<>();
		QuizDao qDao = new QuizDao();
		final int START_INDEX = 1;
		final int MAX_INDEX = 10;

		for (int i = START_INDEX; i <= MAX_INDEX; i++) {
			GameMode gameMode = SetGameModeLogic.execute(journal.getMode());
			String id = journal.getQuizIds().get(i);
			Quiz q = qDao.selectQuizById(gameMode, id);
			quizMap.put(i, q);
		}

		// System.out.println(journal);
		request.setAttribute("journal", journal);
		request.setAttribute("quizMap", quizMap);
		//----------------------------------------------//

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(JspAddress.JOURNAL.getAddress());
		dispatcher.forward(request, response);
	}

}
