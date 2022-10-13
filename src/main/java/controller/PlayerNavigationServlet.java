package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Players;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/playerNavigationServlet")
public class PlayerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String in = request.getParameter("doThisToPlayer");
		PlayerHelper ph  = new PlayerHelper();
		
		String path = "/viewAllPlayersServlet";
		
		if(in.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Players playerToDelete = ph.searchForPlayerById(tempId);
				ph.deletePlayer(playerToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Did not select a player");
			}
		} else if (in.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Players playerToEdit = ph.searchForPlayerById(tempId);
				request.setAttribute("playerToEdit", playerToEdit);
				path = "/edit-player.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Did not select a player");
			}
		} else if (in.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
