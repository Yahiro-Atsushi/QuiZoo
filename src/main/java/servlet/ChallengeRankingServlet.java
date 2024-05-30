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

import businessObject.GetJournalChallengeRankingLogic;
import entity.JournalPort;
import entity.JspAddress;
import entity.VarNames;

@WebServlet("/ChallengeRankingServlet")
public class ChallengeRankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");

		List<JournalPort> journalPortList = GetJournalChallengeRankingLogic.execute();

		request.setAttribute(VarNames.journalPort.name(), journalPortList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(JspAddress.CHALLENGE_RANKING.getAddress());
		if (journalPortList.isEmpty()) {
			dispatcher = request.getRequestDispatcher(JspAddress.EMPTY_JOURNAL_LIST.getAddress());
		}
		dispatcher.forward(request, response);
	}

}
