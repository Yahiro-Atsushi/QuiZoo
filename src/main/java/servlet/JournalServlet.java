package servlet;

import java.io.IOException;
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

import businessObject.GetJournalLogic;
import businessObject.GetJournalPortLogic;
import businessObject.SetGameModeLogic;
import database.QuizDao;
import entity.Address;
import entity.GameMode;
import entity.Journal;
import entity.JournalPort;
import entity.Quiz;
import entity.VarNames;

@WebServlet("/JournalServlet")
public class JournalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//----------------------------------------------//
		// ログインしているユーザーの日付・正解数・履歴IDを持ってくるロジック
		ServletContext application = getServletContext();
		String userName = (String)application.getAttribute(VarNames.userName.name());
		List<JournalPort> journalPortList = GetJournalPortLogic.execute(userName);
		// System.out.println(journal);
		request.setAttribute("journalPort", journalPortList);
		//----------------------------------------------//
		
		/* --------履歴がなかった場合にフォワード先を分岐する処理-------- */

		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.JOURNAL_LIST.getAddress());
		if(journalPortList.isEmpty()) {
			dispatcher = request.getRequestDispatcher(Address.EMPTY_JOURNAL_LIST.getAddress());
		}
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//----------------------------------------------//
		// 踏まれたリンクのボタンからID検索してJournalインスタンスが返ってくるロジック
		// Journalインスタンス（Quizマップ・日付・resultマップ（正解or不正解）・ユーザー名・履歴ID）
		String journalId = request.getParameter("journalId");
		Journal journal = GetJournalLogic.execute(journalId);
		@SuppressWarnings("unchecked")
		List<JournalPort> journalPortList = (List<JournalPort>)request.getAttribute("journalPort");
		Map<Integer, Quiz> quizMap = new TreeMap<>();
		QuizDao qDao = new QuizDao();
		for (int i = 1; i < 11; i++) {
			GameMode gameMode = SetGameModeLogic.execute(journalPortList.get(i).getMode());
			Quiz q = qDao.selectQuizById(gameMode, journal.getQuizIds().get(i));
			quizMap.put(1, q);
		}
		// System.out.println(journal);
		request.setAttribute("journal", journal);
		request.setAttribute("quizMap", quizMap);
		//----------------------------------------------//
				
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.JOURNAL.getAddress());
		dispatcher.forward(request, response);
	}

}