package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.GetJournalLogic;
import businessObject.GetJournalPortRankingLogic;
import entity.Address;
import entity.GameMode;
import entity.Journal;
import entity.JournalPort;
import entity.VarNames;

/**
 * Servlet implementation class RankingServlet
 */
@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//----------------------------------------------//
		// JournalPortを正解数の多い順で10レコード持ってくるロジック
		HttpSession session = request.getSession();
		GameMode mode = (GameMode)session.getAttribute(VarNames.gameMode.name());
		if(mode == null) {
			mode = GameMode.TUTORIAL;
		}
		List<JournalPort> journalPortList = GetJournalPortRankingLogic.execute(mode);
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
		// System.out.println(journal);
		request.setAttribute("journal", journal);
		//----------------------------------------------//
				
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.JOURNAL.getAddress());
		dispatcher.forward(request, response);
	}


}
