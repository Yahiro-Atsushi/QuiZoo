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

@WebServlet("/TutorialServlet")
public class TutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doGet activate.");
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(JspAddress.TUTORIAL.getAddress());
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " / " + getServletName() + ".doPost activate.");
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(JspAddress.TUTORIAL_ANSWER.getAddress());
		dispatcher.forward(request, response);
	}

}
