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
 * Servlet implementation class EditRosterDetailsServlet
 */
@WebServlet("/editRosterDetailsServlet")
public class EditRosterDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRosterDetailsServlet() {
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
		RosterDetailsHelper rh = new RosterDetailsHelper();
		PlayerHelper ph = new PlayerHelper();
		TeamHelper th = new TeamHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		RosterDetails rosterToUpdate = rh.searchForRosterDetailsById(tempId);
		
		String newRosterName = request.getParameter("rosterName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String teamName = request.getParameter("teamName");
		Teams newTeam = th.findTeam(teamName);
		
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedPlayers = request.getParameterValues("allPlayersToAdd");
			List<Players> selectedPlayersInList = new ArrayList<Players>();
			
			for (int i = 0; i < selectedPlayers.length; i++) {
				System.out.println(selectedPlayers[i]);
				Players p = ph.searchForPlayerById(Integer.parseInt(selectedPlayers[i]));
				selectedPlayersInList.add(p);
			}
			rosterToUpdate.setListOfPlayers(selectedPlayersInList);
		} catch (NullPointerException e) {
			List<Players> selectedPlayersInList = new ArrayList<Players>();
			rosterToUpdate.setListOfPlayers(selectedPlayersInList);
		}
		
		rosterToUpdate.setRosterName(newRosterName);
		rosterToUpdate.setStartDate(ld);
		rosterToUpdate.setTeams(newTeam);
		
		rh.updateRoster(rosterToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
	}

}
