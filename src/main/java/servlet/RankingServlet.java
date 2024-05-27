package servlet;

import java.io.IOException;
import java.util.Date;
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
import businessObject.SetGameModeLogic;
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
		System.out.println(new Date() +" / " + getServletName() + ".doGet activate.");
		//----------------------------------------------//
		// リクエストスコープから検索する履歴のゲームモードを取得
		String gameMode = (String)request.getAttribute(VarNames.gameMode.name());
		GameMode mode = SetGameModeLogic.execute(gameMode);
		
		//もしリクエストスコープになければセッションスコープから取得する
		if(gameMode == null ||gameMode.isEmpty()) {
			HttpSession session = request.getSession();
			 mode = (GameMode)session.getAttribute(VarNames.gameMode.name());
		}
		//セッションスコープになかろうと、SetGameLogic内でTESTになっているのでnullにはならない。
		
		// JournalPortを正解数の多い順で10レコード持ってくるロジック
		List<JournalPort> journalPortList = GetJournalPortRankingLogic.execute(mode);
		// System.out.println(journal);
		request.setAttribute("journalPort", journalPortList);
		//----------------------------------------------//
		
		/* --------履歴がなかった場合にフォワード先を分岐する処理-------- */
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.JOURNAL_LIST.getAddress());
		if(journalPortList.isEmpty()) {
			dispatcher = request.getRequestDispatcher(Address.EMPTY_JOURNAL_LIST.getAddress());
		}
		/* --------処理終了-------- */
		
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println(new Date() +" / " + getServletName() + ".doPost activate.");
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
