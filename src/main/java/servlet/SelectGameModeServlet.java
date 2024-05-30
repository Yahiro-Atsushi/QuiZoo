package servlet;

import static entity.GameMode.*;

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

@WebServlet("/SelectGameModeServlet")
public class SelectGameModeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");
		request.setAttribute(VarNames.easy.name(), EASY);
		request.setAttribute(VarNames.normal.name(), NORMAL);
		request.setAttribute(VarNames.hard.name(), HARD);
		request.setAttribute(VarNames.challenge.name(), CHALLENGE);

		RequestDispatcher rdp = request.getRequestDispatcher(JspAddress.SELECT_GAMEMODE.getAddress());
		rdp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doPost activate.");

		String isContinue = request.getParameter("action");
		String continueStr = "つづきから";
		String beginStr = "はじめから";
		String address = "/MainServlet";

		if (isContinue != null) {
			HttpSession session = request.getSession();

			if (isContinue.equals(continueStr)) {
				//続行の処理
				session.setAttribute(VarNames.isInProgress.name(), true);
				Game game = (Game) session.getAttribute(VarNames.game.name());
				
				if(game == null) {
					RequestDispatcher rdp = request.getRequestDispatcher(address);
					request.setAttribute(VarNames.gameIsAbone.name(), true);
					rdp.forward(request, response);
					return;
				}
			
				int section = game.getQuizCount();
				if (section > 0) {
					game.setQuizCount(section - 1);
				}
				session.setAttribute(VarNames.gameMode.name(), game.getMode());
				address = "/GameServlet";
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
