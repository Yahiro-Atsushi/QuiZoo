package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessObject.GetJournalChallengeRankingLogic;
import entity.Address;
import entity.JournalPort;

/**
 * Servlet implementation class ChallengeRankingServlet
 */
@WebServlet("/ChallengeRankingServlet")
public class ChallengeRankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<JournalPort> journalPortList = GetJournalChallengeRankingLogic.execute();
		
		request.setAttribute("journalPort", journalPortList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.CHALLENGE_RANKING.getAddress());
		if(journalPortList.isEmpty()) {
			dispatcher = request.getRequestDispatcher(Address.EMPTY_JOURNAL_LIST.getAddress());
		}
		dispatcher.forward(request, response);
	}

}
