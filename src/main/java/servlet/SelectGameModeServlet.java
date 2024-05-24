package servlet;

import static entity.GameMode.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Address;
import entity.GameMode;
import entity.VarNames;

/**
 * Servlet implementation class SelectGameModeServlet
 */
@WebServlet("/SelectGameModeServlet")
public class SelectGameModeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute(VarNames.easy.name(), EASY);
		request.setAttribute(VarNames.normal.name(), NORMAL);
		request.setAttribute(VarNames.hard.name(), HARD);
		request.setAttribute(VarNames.challenge.name(), CHALLENGE);
		request.setAttribute("test", GameMode.TEST);
		
		RequestDispatcher rdp = 
				request.getRequestDispatcher(Address.SELECT_GAMEMODE.getAddress());
		rdp.forward(request, response);
	}
}
