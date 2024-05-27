package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Address;
import entity.Game;
import entity.VarNames;

/**
 * Servlet implementation class AbendGameServlet
 */
@WebServlet("/AbendGameServlet")
public class AbendGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rdp = request.getRequestDispatcher(Address.ABEND_GAME.getAddress());
		rdp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String isContinue = request.getParameter("action");
		String continueStr = "つづきから";
		String beginStr = "はじめから";
		String address = "/MainServlet";
		
		if (isContinue != null) {
			HttpSession session = request.getSession();
			session.setAttribute("isInProgress", true);
			
			if(isContinue.equals(continueStr)) {
				//続行の処理
				Game game = (Game)session.getAttribute(VarNames.game.name());
				session.setAttribute(VarNames.gameMode.name(), game.getMode());
				address = "/GameServlet";
			}
			
			if(isContinue.equals(beginStr)) {
				session.setAttribute("isInProgress", true);
				session.removeAttribute(VarNames.game.name());
				address = "/SelectGameModeServlet";
			}
		}
		RequestDispatcher rdp = request.getRequestDispatcher(address);
		rdp.forward(request, response);
	}

}
