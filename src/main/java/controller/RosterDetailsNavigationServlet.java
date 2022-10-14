package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RosterDetails;

/**
 * Servlet implementation class RosterDetailsNavigationServlet
 */
@WebServlet("/rosterDetailsNavigationServlet")
public class RosterDetailsNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RosterDetailsNavigationServlet() {
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
		// TODO Auto-generated method stub
		RosterDetailsHelper rh = new RosterDetailsHelper();
		String in = request.getParameter("doThisToRoster");

		if (in == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);

		} else if (in.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				RosterDetails rosterToDelete = rh.searchForRosterDetailsById(tempId);
				rh.deleteRoster(rosterToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Did not select an option");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
			}

		} else if (in.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				RosterDetails rosterToEdit = rh.searchForRosterDetailsById(tempId);
				request.setAttribute("rosterToEdit", rosterToEdit);
				request.setAttribute("month", rosterToEdit.getStartDate().getMonthValue());
				request.setAttribute("date", rosterToEdit.getStartDate().getDayOfMonth());
				request.setAttribute("year", rosterToEdit.getStartDate().getYear());
				PlayerHelper allPlayers = new PlayerHelper();
				
				request.setAttribute("allPlayers", allPlayers.showAllPlayers());
							
				if(allPlayers.showAllPlayers().isEmpty()){
						request.setAttribute("allPlayers", " ");
				}
				getServletContext().getRequestDispatcher("/edit-roster.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
			} 

		}
	}

}
