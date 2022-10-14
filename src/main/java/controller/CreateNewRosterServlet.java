package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Players;
import model.RosterDetails;
import model.Teams;

/**
 * Servlet implementation class CreateNewRosterServlet
 */
@WebServlet("/createNewRosterServlet")
public class CreateNewRosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewRosterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerHelper ph = new PlayerHelper();
		String rosterName = request.getParameter("rosterName");
		System.out.println("Roster Name: " + rosterName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String teamName = request.getParameter("teamName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedPlayers = request.getParameterValues("allPlayersToAdd");
		List<Players> selectedPlayersInRoster = new ArrayList<Players>();
		
		if(selectedPlayers != null && selectedPlayers.length > 0) {
			for(int i = 0; i < selectedPlayers.length; i++) {
				Players p = ph.searchForPlayerById(Integer.parseInt(selectedPlayers[i]));
			}
		}
		
		Teams teams = new Teams(teamName);
		RosterDetails rd = new RosterDetails(rosterName, ld, teams);
		
		rd.setListOfPlayers(selectedPlayersInRoster);
		RosterDetailsHelper rdh = new RosterDetailsHelper();
		rdh.insertNewRosterDetails(rd);
		
		System.out.println("Success");
		System.out.println(rd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
