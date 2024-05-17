package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Address;

@WebServlet("/JournalServlet")
public class JournalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//----------------------------------------------//
		// ログインしているユーザーの日付・正解数・履歴IDを持ってくるロジック
		// List<JournalPort> journalPortList = (ユーザーの解答した日付・正解数・IDがリストで返ってくるロジック)
		// System.out.println(journal);
		// request.setAttribute("journalPort", journalPortList);
		//----------------------------------------------//
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.JOURNALLIST.getAddress());
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//----------------------------------------------//
		// 踏まれたリンクの日付からID検索してJournalインスタンスが返ってくるロジック
		// Journalインスタンス（Quizマップ・日付・resultマップ（正解or不正解）・ユーザー名・履歴ID）
		// Journal journal = (IDからJournalインスタンスが返ってくるロジック)
		// System.out.println(journal);
		// request.setAttribute("journal", journal);
		//----------------------------------------------//
				
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.JOURNAL.getAddress());
		dispatcher.forward(request, response);
	}
	

}
