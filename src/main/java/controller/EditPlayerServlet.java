package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Players;

/**
 * Servlet implementation class EditPlayerServlet
 */
@WebServlet("/editPlayerServlet")
public class EditPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerHelper ph = new PlayerHelper();
		
		String name = request.getParameter("name");
		String stringNumber = request.getParameter("number");
		String stringStartDate = request.getParameter("startdate");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		LocalDate startDate = LocalDate.parse(stringStartDate);
		int number = Integer.parseInt(stringStartDate);
		
		Players playerToUpdate = ph.searchForPlayerById(tempId);
		playerToUpdate.setName(name);
		playerToUpdate.setNumber(number);
		playerToUpdate.setStartDate(startDate);
		
		ph.updatePlayers(playerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}

}
