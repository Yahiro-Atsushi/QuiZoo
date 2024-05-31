package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Game;
import entity.JspAddress;
import entity.VarNames;

@WebServlet("/AbendGameServlet")
public class AbendGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");

		RequestDispatcher rdp = request.getRequestDispatcher(JspAddress.ABEND_GAME.getAddress());
		rdp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doPost activate.");

		String isContinue = request.getParameter("action");
		System.out.println("     action is " + isContinue);
		String continueStr = "つづきから";
		String beginStr = "はじめから";
		String address = "/MainServlet";

		if (isContinue != null) {
			HttpSession session = request.getSession();

			if (isContinue.equals(continueStr)) {
				//続行の処理
				session.setAttribute(VarNames.isInProgress.name(), true);
				System.out.println("      Set SessionScope isInProgress.");
				Game game = (Game) session.getAttribute(VarNames.game.name());
				System.out.println("      Get SessionScope game.");
				System.out.println(" 　    game is " + game);
				if(game == null) {
					RequestDispatcher rdp = request.getRequestDispatcher(address);
					request.setAttribute(VarNames.gameIsAbone.name(), true);
					rdp.forward(request, response);
					return;
				}
			
				int section = game.getQuizCount();
				System.out.println("     section = " + section);
				if (section > 0) {
					game.setQuizCount(section - 1);
				}
				System.out.println("     section = " + section);
				session.setAttribute(VarNames.gameMode.name(), game.getMode());
				System.out.println("     Set SessionScope game.");
				System.out.println(" game is " + game);
				address = "/GameServlet";
				System.out.println();
			}

			if (isContinue.equals(beginStr)) {
				session.setAttribute(VarNames.isInProgress.name(), false);
				session.removeAttribute(VarNames.game.name());
				session.removeAttribute(VarNames.gameMode.name());
				session.removeAttribute(VarNames.randomIdList.name());
				doGet(request, response);
				return;
			}
		}
		RequestDispatcher rdp = request.getRequestDispatcher(address);
		rdp.forward(request, response);
	}

}
