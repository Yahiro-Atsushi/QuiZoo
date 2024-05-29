package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.JspAddress;

@WebServlet("/AbendGameServlet")
public class AbendGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");

		RequestDispatcher rdp = request.getRequestDispatcher(JspAddress.ABEND_GAME.getAddress());
		rdp.forward(request, response);
	}

}
