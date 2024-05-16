package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.Game;
import model.ResultLogic;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute("game");
		
		//---------------------------------------------------//
		// 結果を(1, "正解")のように表示させるロジック
		Map<Integer, String> result = ResultLogic.execute(game);
		session.setAttribute("result", result);
		//---------------------------------------------------//
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(Address.RESULT.getAddress());
		dispatcher.forward(request, response);

	}

}
